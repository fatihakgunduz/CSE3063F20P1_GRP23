class Calculator:
    def __init__(self):
        pass

    def attendance_calculator(self, attend, absence):
        total_attendance = attend + absence
        attendance_ratio = attend/total_attendance
        attendance_percent = attendance_ratio*100
        return attendance_percent

    def quiz_note_calculator(self, students_quiz):
        true = 0
        false = 0
        for x in students_quiz.question_list:
            if(x.is_correct):
                true += 1
            else:
                false += 1
        total_question = true + false
        true_ratio = true/total_question
        true_percent = true_ratio*100
        return true_percent

    def quiz_grade_adder(self,grades):
        sum = 0
        for x in grades:
            sum += x
        return sum

    def total_quiz_grade_calculator(self, grades):
        sum_grade = self.quiz_grade_adder(grades)
        grade = sum_grade/len(grades)
        return grade


