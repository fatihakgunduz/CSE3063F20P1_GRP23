class Quiz_Checker:
    def __init__(self):
        self.true = 0
        self.false = 0

    def check(self, students_quiz, correct_answers):
        i = 0
        for i in range(10):                 #Burasi poll icindeki soru sayisiyla uyumlu olmali
            if(students_quiz.answer_list[i].answer_text == correct_answers[i].answer_text):
                students_quiz.question_list[i].correct()
            i += 1


