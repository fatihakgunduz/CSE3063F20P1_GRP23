import pandas as pd
from Student import Student
class Course_Class:
    def __init__(self, class_name):
        self.class_name = class_name
        self.student_list = []
        #print("init")
        siniflist_columns = ['No', 'Öğrenci No', 'Adı', 'Soyadı', 'Açıklama']
        df = pd.read_excel("CES3063_Fall2020_rptSinifListesi.XLS", usecols=siniflist_columns)
        self.class_creator(df)

    def add_student(self, student):
        #print("add_student")
        self.student_list.append(student)

    def print_students(self):
        print(self.student_list)

    def class_creator(self, df):
        #print("class_creator")
        for index, row in df.iterrows():
            student = Student(df.iloc[index, 1], df.iloc[index, 2], df.iloc[index, 3], df.iloc[index, 4])
            self.add_student(student)

'''''
    def find_student(self):
        for name in self.student_list:
                print(name.student_id)
'''