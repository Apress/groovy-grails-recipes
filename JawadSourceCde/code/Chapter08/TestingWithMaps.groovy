class CCApp{
  def isApproved(creditHistory, user){
    def score = creditHistory.getCreditScore(user.ssn)
    if (score > 600)
      return true
      return false
  }
}
class CreditHistory{
  def getCreditScore(int SSN){
    // some expensive code
  }
}

def creditHistory = [getCreditScore:{ssn ->
  if (ssn == 123)
    return 400
  if (ssn == 12)
  return 700
    return 500
}]

def user1 = [ssn:123]
def user2 = [ssn:12]
def user3 = [ssn:1]
             
def app = new CCApp()
assert app.isApproved(creditHistory,user1) == false
assert app.isApproved(creditHistory,user2) == true
assert app.isApproved(creditHistory,user3) == false
