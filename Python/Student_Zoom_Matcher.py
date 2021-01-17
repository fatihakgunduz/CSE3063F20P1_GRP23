from unicode_tr import unicode_tr

class Student_Zoom_Matcher():
    def __init__(self, unmatched_student_list):
        self.unmatched_zoom_acc_list = []
        self.unmatched_student_list = unmatched_student_list
        self.matched_student_list = []


    def add_zoom_acc(self, zoom_acc):
        matched = 0
        for i in self.unmatched_student_list:
            #print("User Name:" + unicode_tr(str(zoom_acc.username)).lower())
            #print("Full Name:" + unicode_tr(str(i.name + " " + i.surname)).lower())
            if(unicode_tr(str(zoom_acc.username)).lower() == unicode_tr(str(i.name + " " + i.surname)).lower()):
                matched = 1
                break
            else:
                for k in self.matched_student_list:
                    if (unicode_tr(str(zoom_acc.username)).lower() == unicode_tr(str(k.zoom_account.username).lower())):
                        matched = -1
                        break
                    else:
                       matched = 0
        if(matched == 1):
            i.add_zoom_account(zoom_acc)
            self.matched_student_list.append(i)
            self.unmatched_student_list.remove(i)
        elif(matched == 0):
            self.unmatched_zoom_acc_list.append(zoom_acc)
        else:
            pass

