class UserController {
  def authenticationClient

  def index = {
    render(view: "login")
  }
  def login = {
    def result = authenticationClient.login(params.name, params.password)
    if (result instanceof Number && result > 0 ) {      //User authenticatied
      session.user = User.get(result)
      render "success"
    }
    else {
      //User not authenticated
      render(view: "login", model: [message: result])
    }
  }
}
