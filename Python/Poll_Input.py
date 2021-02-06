import pandas as pd
from Student_Zoom import Student_Zoom


class Poll_Input():
    def __init__(self):
        pass

    def poll_reader(self, file):
        poll_columns = ['No', 'User Name', 'User Email', 'Submitted Date/Time', 'Q1', 'A1', 'Q2', 'A2', 'Q3', 'A3',
                        'Q4', 'A4', 'Q5', 'A5', 'Q6', 'A6', 'Q7', 'A7', 'Q8', 'A8', 'Q9', 'A9', 'Q10', 'A10', ]
        poll = pd.read_csv(file, encoding="utf-8", usecols=poll_columns)
        return poll

