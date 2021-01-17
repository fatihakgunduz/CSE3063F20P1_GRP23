class Answer_Key:
    def __init__(self, poll_name):
        self.poll_name = poll_name
        self.q_list = []
        self.correct_answer_list = []

    def add_correct_answer(self, ans):
        self.correct_answer_list.append(ans)

    def add_question(self, question):
        self.q_list.append(question)