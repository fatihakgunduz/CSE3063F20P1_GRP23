from unicode_tr import unicode_tr
from Student_Zoom import Student_Zoom
class Student_Zoom_Matcher():
    def __init__(self, unmatched_student_list, poll):
        self.unmatched_zoom_acc_list = []
        self.unmatched_student_list = unmatched_student_list
        self.matched_student_list = []
        for index, row in poll.iterrows():
            st_zoom = Student_Zoom(poll.iloc[index, 1], poll.iloc[index, 2])
            self.match(st_zoom)




    def match(self, zoom_acc):
        matched = 0
        tr_fixer = str.maketrans("ğĞıİöÖüÜşŞçÇ","gGiIoOuUsScC")
        tr_fixer2 = str.maketrans("IİÖÜ","ıiöü")
        for x in self.unmatched_student_list:
            temp_name = x.name
            full_name = x.name.split()
            if(len(full_name) == 1):
                if((str(zoom_acc.username).translate(tr_fixer) == str(x.name + " " + x.surname)) or (str(zoom_acc.username).translate(tr_fixer2) == str(x.name + " " + x.surname))):
                    matched = 1
                    break
                elif(( (str(full_name[0]).translate(tr_fixer).lower()) in (str(zoom_acc.username).translate(tr_fixer).lower())) and   (str(x.surname).translate(tr_fixer).lower()) in (str(zoom_acc.username).translate(tr_fixer).lower())):
                    matched = 1
                    break
            else:
                if ((str(zoom_acc.username).translate(tr_fixer).lower() == str(str(full_name[0].translate(tr_fixer).lower()) + " " + x.surname)) or (str(zoom_acc.username).translate(tr_fixer2).lower() == str(str(full_name[0].translate(tr_fixer2).lower()) + " " + x.surname).lower())):
                    matched = 1
                    break
                elif((str(zoom_acc.username).translate(tr_fixer).lower() == str(str(full_name[1].translate(tr_fixer).lower()) + " " + x.surname)) or (str(zoom_acc.username).translate(tr_fixer2).lower() == str(str(full_name[1].translate(tr_fixer2).lower()) + " " + x.surname).lower())):
                    matched = 1
                    break
                elif((str(zoom_acc.username).translate(tr_fixer).lower() == str(x.name + " " + x.surname).lower()) or (str(zoom_acc.username).translate(tr_fixer2).lower() == str(x.name + " " + x.surname).lower())):
                    matched = 1
                    break
                elif((str(full_name[0]).translate(tr_fixer).lower() in str(zoom_acc.username).translate(tr_fixer).lower()) and str(x.surname).lower() in str(zoom_acc.username).translate(tr_fixer).lower()):
                    matched = 1
                    break
                elif ((str(full_name[1]).translate(tr_fixer).lower() in str(zoom_acc.username).translate(tr_fixer).lower()) and str(x.surname).lower() in str(zoom_acc.username).translate(tr_fixer).lower()):
                    matched = 1
                    break
                elif ((str(full_name[0]).translate(tr_fixer2).lower() in str(zoom_acc.username).translate(tr_fixer2).lower()) and str(x.surname).lower() in str(zoom_acc.username).translate(tr_fixer2).lower()):
                    matched = 1
                    break
                elif ((str(full_name[1]).translate(tr_fixer2).lower() in str(zoom_acc.username).translate(tr_fixer2).lower()) and str(x.surname).lower() in str(zoom_acc.username).translate(tr_fixer2).lower()):
                    matched = 1
                    break
                else:
                    for k in self.matched_student_list:
                        if (unicode_tr(str(zoom_acc.username)).lower() == unicode_tr(str(k.zoom_account.username).lower())):
                            matched = -1
                            break
                        else:
                            matched = 0
        if (matched == 1):
            x.add_zoom_account(zoom_acc)
            self.matched_student_list.append(x)
            self.unmatched_student_list.remove(x)
        elif (matched == 0):
            self.unmatched_zoom_acc_list.append(zoom_acc)
        else:
            pass