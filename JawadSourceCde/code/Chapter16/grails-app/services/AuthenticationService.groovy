import com.apress.groovygrailsrecipes.services.Authentication

class AuthenticationService implements Authentication  {
  boolean transactional = true

  def login(name, password) {
    def user = User.findByName(name)
    if (user) {
      if (user.password == password) {
        return user.id
      }
      else {
        return "Wrong password"
      }
    }
    else {
      return "User not found"
    }
  }
}