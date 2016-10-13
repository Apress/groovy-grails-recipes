import groovy.mock.interceptor.StubFor
class CCApp{
  def isApproved(user){
    CreditHistory creditHistory = new CreditHistory()
    def  score = creditHistory.getCreditScore(user.ssn)
    def numberOfBadAccounts = creditHistory.getBadAccounts(user.ssn).size()
    if (numberOfBadAccounts > 1) return false
    if (score > 600)
        return true
    return false
    }
}

class CreditHistory{
    def getCreditScore(int ssn){
        //some expensive code
    }
    def getBadAccounts(int ssn){
        //some expensive code
    }    
}
def creditHistoryStub = new StubFor(CreditHistory)
//getBadAccounts can be called at most twice
creditHistoryStub.demand.getBadAccounts(1..2) { ssn ->  
    if (ssn == 123) return ["Account 1", "Account 2"]
    if (ssn == 12) return ["Account 1"]
    return [1,2]
}
//getCreditScore can be called at most twice
creditHistoryStub.demand.getCreditScore(1..2) { ssn -> 
    if (ssn == 123) return 400
    if (ssn == 12) return 700
    return 500
}
def user1 = [ssn:123]
def user2 = [ssn:12]

def app = new CCApp()
creditHistoryStub.use {
  assert !app.isApproved(user1)
  assert app.isApproved(user2)
}
