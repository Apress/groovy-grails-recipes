class ViewForumControllerTests extends GroovyTestCase {
  void testNotLoggedIn(){
    def vfc = new ViewForumController()
    vfc.submit()
    assertEquals "/viewForum/login", vfc.response.redirectedUrl
  }
 void testLoggedIn(){
    def vfc = new ViewForumController()
    vfc.session.user = 'username'
    vfc.submit()
    assertEquals vfc.modelAndView.model.message, "Topic posted"
  }

}