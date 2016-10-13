import groovy.mock.interceptor.StubFor

class CCApp{
  def isApproved(user){
    def  score = new CreditHistory().getCreditScore(user.ssn)
    if (score > 600)
      return true
      return false
  }
}
class CreditHistory{
  def getCreditScore(int ssn){
    //some expensive code
  }
}

def creditHistoryStub = new StubFor(CreditHistory)
creditHistoryStub.demand.getCreditScore { ssn -> 
  if (ssn == 123) return 400
  if (ssn == 12) return 700
  return 500
}

def user1 = [ssn:123]
def app = new CCApp()

creditHistoryStub.use {
  assert !app.isApproved(user1)
}
