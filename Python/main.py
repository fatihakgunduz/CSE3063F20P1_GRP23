import pandas as pd
import Course_Class
from Student_Zoom import Student_Zoom
from Student import Student
from Answer import Answer
from Answer_Key import Answer_Key
from Question import Question
from Student_Zoom_Matcher import Student_Zoom_Matcher
from Poll import Poll_Attendance, Poll_Quiz
from Calculator import Calculator
from Quiz_Checker import Quiz_Checker

cor_answer = pd.read_csv("csvFiles/answers.csv", encoding="utf-8")
Ans_Key = Answer_Key(cor_answer.columns[0])
i = 0
for index in cor_answer.iterrows():
    ans = Answer(cor_answer.iloc[i,0])
    Ans_Key.add_correct_answer(ans)
    i += 1

x = 0
for index in cor_answer.iterrows():
    question = Question(cor_answer.iloc[x].name)
    Ans_Key.add_question(question)
    x += 1

siniflist_columns = ['No','Öğrenci No','Adı','Soyadı','Açıklama']
df = pd.read_excel("CES3063_Fall2020_rptSinifListesi.XLS",usecols=siniflist_columns)
CSE = Course_Class.Course_Class('CSE')

for index, row in df.iterrows():
    st = Student(df.iloc[index,1],df.iloc[index,2],df.iloc[index,3],df.iloc[index,4])
    CSE.add_student(st)

mesutozil = Student_Zoom_Matcher(CSE.student_list)

poll_columns = ['No', 'User Name', 'User Email', 'Submitted Date/Time','Q1','A1','Q2','A2','Q3','A3','Q4','A4','Q5','A5','Q6','A6','Q7','A7','Q8','A8','Q9','A9','Q10','A10',]
poll = pd.read_csv("csvFiles/CSE3063_20201123_Mon_zoom_PollReport.csv", encoding="utf-8", usecols=poll_columns)
for index, row in poll.iterrows():
    st_zoom = Student_Zoom(poll.iloc[index,1],poll.iloc[index,2])
    mesutozil.add_zoom_acc(st_zoom)

attend = False
islemsirasi = False                                             #Bu isim degissin
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
                for k in poll.iloc[index,lambda poll: [4,6,8,10,12,14,16,18,20,22] ]:             #df.iloc[lambda x: x.index % 2 == 0]
                    if(k != None):
                        temp_question = Question(k)
                        quiz.add_question(temp_question)
                for l in poll.iloc[index,lambda poll: [5,7,9,11,13,15,17,19,21,23] ]:
                    if(l != None):
                        temp_answer = Answer(l)
                        quiz.add_student_answer(temp_answer)
                if(quiz.question_list[1].question_text == Ans_Key.q_list[1].question_text):
                    quiz.give_name_to_poll(Ans_Key.poll_name)
                else:
                    quiz.give_name_to_poll('Couldnt find')
                x.poll_adder(quiz)
    if(islemsirasi):
        attendance_poll = Poll_Attendance(x, attend)


q_check = Quiz_Checker()
for x in mesutozil.matched_student_list:
    if(len(x.poll_list) != 0):
        q_check.check(x.poll_list[0],Ans_Key.correct_answer_list)

calc = Calculator()

for x in mesutozil.matched_student_list:
    print(str(x.student_id)  + " - " + str(x.name) + " - " + str(x.surname) + " - " + str(x.zoom_account.username) + " - " + str(x.zoom_account.email))
    print(" katildi: " + str(x.attendance_counter) + " katilmadi: " + str(x.absence_counter) + " Attendance: " + str(calc.attendance_calculator(x.attendance_counter,x.absence_counter)))
    print(" Quiz Score: " + str(x.student_grade(calc)))

for x in mesutozil.matched_student_list:
    x.total_grade(calc)

for x in mesutozil.matched_student_list:
    print(str(x.tot_grade))

#print(Ans_Key.poll_name)
#print(Ans_Key.correct_answer_list)
#print(Ans_Key.q_list[1].question_text)

#print(Ans_Key.q_list)

#print(cor_answer.iloc[1].name)
