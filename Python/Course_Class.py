class Course_Class:
    def __init__(self, class_name):
        self.class_name = class_name
        self.student_list = []

    def add_student(self, st):
        self.student_list.append(st)

    def print_students(self):
        print(self.student_list)

'''''
    def find_student(self):
        for name in self.student_list:
                print(name.student_id)
'''