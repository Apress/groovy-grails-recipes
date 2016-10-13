class UserController {
  def index = {
    render (view:"login")
  }
  def login = {
    def user = User.findByName(params.name)
    def message
    if (user){
     if (user.password == params.password){
       session.user = user
       redirect(controller:"viewForum")
     }
     else {
       message = "Wrong password"
     }
   }
  else {
    message = "User not found"
  }
  render (view:"login", model:[message:message])
  }
}