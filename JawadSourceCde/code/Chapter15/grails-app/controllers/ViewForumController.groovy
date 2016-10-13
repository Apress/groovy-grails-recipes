class ViewForumController {
  def submit = {
    if (!session.user){
       redirect(action:'login')
       return false
    }
    else {
        render (view:"success", model:[message:"Topic posted"])
    }
  }
}