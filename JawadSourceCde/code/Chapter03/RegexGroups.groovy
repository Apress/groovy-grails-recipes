def text = """
Lorem 1:30 PM ipsum dolor 12:00 PM sit amet, consectetuer adipiscing elit.
"""
 
def HOUR = /10|11|12|[0-9]/
def MINUTE = /[0-5][0-9]/
def AM_PM = /AM|PM/
def time = /($HOUR):($MINUTE) ($AM_PM)/

def matcher = text =~ time

assert matcher[0] == ["1:30 PM", "1", "30", "PM"] //First Match

assert matcher[0][0] == "1:30 PM" //First match group in the first match
assert matcher[0][1] == "1" //Second match group in the first match (HOUR)
assert matcher[0][2] == "30" //Third match group in the first match (MINUTE)
assert matcher[0][3] == "PM" //Fourth match group in the first match (AM_PM)

assert matcher[1] == ["12:00 PM", "12", "00", "PM"] //Second Match
assert matcher[1][0] == "12:00 PM" //First match group in the second match
assert matcher[1][1] == "12" //Second match group in the second match (HOUR)
assert matcher[1][2] == "00" //Third match group in the second match (MINUTE)
assert matcher[1][3] == "PM" //Fourth match group in the second match (AM_PM)
