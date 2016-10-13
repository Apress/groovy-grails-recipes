class ViewForumControllerTests extends GroovyTestCase {

  void setUp(){
    new Forum(name:"Groovy",description:"General Groovy Discussion").save()    
  }

  void testSubmitREST() {
        def tc = new ViewForumController()
        tc.params."subject" = "Groovy JDBC qustion"
        tc.params."message" = "How do I run a stored procedure in Groovy?"
        tc.params."forum" = "Groovy"
        tc.submitREST()
        assertEquals tc.response.contentAsString,"1"
        assertEquals tc.response.status,201
    }
}
