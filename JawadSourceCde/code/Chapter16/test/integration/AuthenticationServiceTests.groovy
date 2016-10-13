class AuthenticationServiceTests extends GroovyTestCase {
  def authenticationService

  void setUp() {
    def user = new User(name: "Bashar", password: "pass", numberOfLogins:0)
    user.save(flush: true)
  }

  void testLogin() {
    def success = authenticationService.login("Bashar", "pass")
    assertEquals success, 1
    def wrongPassword = authenticationService.login("Bashar", "wrong")
    assertEquals wrongPassword, "Wrong password"
    def userNotFound = authenticationService.login("Sami", "pass")
    assertEquals userNotFound, "User not found"
  }
}