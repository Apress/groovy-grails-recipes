import groovy.mock.interceptor.MockFor
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
def creditHistoryMock = new MockFor(CreditHistory)

creditHistoryMock.demand.getCreditScore { ssn -> 
  if (ssn == 123) return 400
  if (ssn == 12) return 700
  return 500
}

creditHistoryMock.demand.getBadAccounts { ssn -> 
  return [1,2]
}

def user1 = [ssn:123]

def app = new CCApp()
creditHistoryMock.use {
  assert !app.isApproved(user1)
}
