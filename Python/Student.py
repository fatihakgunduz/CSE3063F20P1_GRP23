from Calculator import Calculator
class Student:
    def __init__(self, student_id, name, surname, is_repeat):
        self.student_id = student_id
        self.name = name
        self.surname = surname
        self.is_repeat = is_repeat
        self.attendance_score = 0
        self.quiz_score = 0
        self.zoom_account = None
        self.attendance_counter = 0
        self.absence_counter = 0
        self.poll_list = []
        self.grades = []
        self.tot_grade = 0

    def add_zoom_account(self,zoom_account):
        self.zoom_account = zoom_account

    def attendance_counter_increaser(self):
        self.attendance_counter += 1

    def absence_counter_increaser(self):
        self.absence_counter += 1

    def poll_adder(self, poll):
        self.poll_list.append(poll)

    def student_grade(self, calc):
        if(len(self.poll_list) != 0):
            grade = calc.quiz_note_calculator(self.poll_list[0])
            self.grades.append(grade)
            return grade
        else:
            self.grades.append(0)
            return 0

    def total_grade(self, calc):
        tot_grade = calc.total_quiz_grade_calculator(self.grades)
        self.tot_grade = tot_grade
