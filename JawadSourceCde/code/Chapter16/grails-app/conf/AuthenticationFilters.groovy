class AuthenticationFilters {
  def filters = {
    loginCheck(controller: 'viewForum', action: '*') {
      before = {
       //actionName returns the name of the current action
       if (!session.user){
         redirect(controller:"user",action:"index")
         return false
        }
      }
    }
  }
}