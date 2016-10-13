import java.sql.Date as SQLDate
def date = new Date()
def sqlDate = new SQLDate(date.time)
assert date == sqlDate
