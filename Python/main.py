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
from Poll_Input import Poll_Input
from Quiz_Decider import Quiz_Decider
import Output


Ans_Key = Answer_Key("csvFiles/answers.csv")

CSE = Course_Class.Course_Class('CSE')

poll = Poll_Input()
this_poll = poll.poll_reader("csvFiles/CSE3063_20201123_Mon_zoom_PollReport.csv")

mesutozil = Student_Zoom_Matcher(CSE.student_list, this_poll)

qd = Quiz_Decider()
qd.quiz_decider(mesutozil, this_poll, Ans_Key)

q_check = Quiz_Checker()
for x in mesutozil.matched_student_list:
    if(len(x.poll_list) != 0):
        q_check.check(x.poll_list[0],Ans_Key.correct_answer_list)

calc = Calculator()

for x in mesutozil.matched_student_list:
    print(str(x.student_id)  + " - " + str(x.name) + " - " + str(x.surname) + " - " + str(x.zoom_account.username) + " - " + str(x.zoom_account.email))
    print(" katildi: " + str(x.attendance_counter) + " katilmadi: " + str(x.absence_counter) + " Attendance: " + str(calc.attendance_calculator(x.attendance_counter,x.absence_counter)))
    print(" Quiz Score: " + str(x.student_grade(calc)))


print("[][][][][][][][][][][][][][][][][][][][[][][][][][][][][][][][][]")
print("ANOMALIES")
for x in mesutozil.unmatched_student_list:
    print(str(x.name) + " " + str(x.surname))

writer = Output.Output()
writer.write(mesutozil.matched_student_list)

#print(Ans_Key.poll_name)
#print(Ans_Key.correct_answer_list)
#print(Ans_Key.q_list[1].question_text)

#print(Ans_Key.q_list)

#print(cor_answer.iloc[1].name)
