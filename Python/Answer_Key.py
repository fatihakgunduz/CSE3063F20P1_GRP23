from Answer import Answer
from Question import Question
import pandas as pd
class Answer_Key:
    def __init__(self, file):
        cor_answer = pd.read_csv(file, encoding="utf-8")
        self.poll_name = cor_answer.columns[0]
        self.q_list = []
        self.correct_answer_list = []
        i = 0
        for index in cor_answer.iterrows():
            ans = Answer(cor_answer.iloc[i, 0])
            self.add_correct_answer(ans)
            i += 1

        x = 0
        for index in cor_answer.iterrows():
            question = Question(cor_answer.iloc[x].name)
            self.add_question(question)
            x += 1


    def add_correct_answer(self, ans):
        self.correct_answer_list.append(ans)

    def add_question(self, question):
        self.q_list.append(question)