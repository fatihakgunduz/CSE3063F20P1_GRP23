from Answer import Answer
from Poll import Poll_Quiz, Poll_Attendance
from Question import Question

class Quiz_Decider():
    def __init__(self):
        pass

    def quiz_decider(self, mesutozil, poll, Ans_Key):
        attend = False
        islemsirasi = False  # Bu isim degissin
        for x in mesutozil.matched_student_list:
            for index, row in poll.iterrows():
                if (poll.iloc[index, 4] == 'Are you attending this lecture?'):
                    islemsirasi = True
                    if (poll.iloc[index, 1] == x.zoom_account.username):
                        attend = True
                        break
                    else:
                        attend = False
                else:
                    if (poll.iloc[index, 1] == x.zoom_account.username):
                        quiz = Poll_Quiz()
                        for k in poll.iloc[index, lambda poll: [4, 6, 8, 10, 12, 14, 16, 18, 20, 22]]:  # df.iloc[lambda x: x.index % 2 == 0]
                            if (k != None):
                                temp_question = Question(k)
                                quiz.add_question(temp_question)
                        for l in poll.iloc[index, lambda poll: [5, 7, 9, 11, 13, 15, 17, 19, 21, 23]]:
                            if (l != None):
                                temp_answer = Answer(l)
                                quiz.add_student_answer(temp_answer)
                        if (quiz.question_list[1].question_text == Ans_Key.q_list[1].question_text):
                            quiz.give_name_to_poll(Ans_Key.poll_name)
                        else:
                            quiz.give_name_to_poll('Couldnt find')
                        x.poll_adder(quiz)
            if (islemsirasi):
                attendance_poll = Poll_Attendance(x, attend)