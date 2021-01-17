class Question():
    def __init__(self, question_text):
        self.question_text = question_text
        self.is_correct = False

    def correct(self):
        self.is_correct = True