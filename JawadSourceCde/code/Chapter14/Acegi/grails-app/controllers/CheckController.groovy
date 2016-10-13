import org.grails.plugins.springsecurity.service.AuthenticateService
class CheckController {
  AuthenticateService authenticateService
  def index = {
    def user = authenticateService.userDomain()
    if (user == null) {
      render "not logged in"
    }
    else {
      render "Welcome " + user.username + ":" + user.getAuthorities()
    }
  }
}