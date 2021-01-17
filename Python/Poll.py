from Student import Student
import Question
class Poll:
    def __init__(self):
        self.question_list = []
        self.answer_list = []
        self.name = None

class Poll_Attendance(Poll):
    def __init__(self, student, is_attending):
        if(is_attending):
            student.attendance_counter_increaser()
        else:
            student.absence_counter_increaser()

class Poll_Quiz(Poll):
    def add_question(self, q):
        self.question_list.append(q)

    def add_student_answer(self, a):
        self.answer_list.append(a)

    def give_name_to_poll(self, name):
        self.name = name
