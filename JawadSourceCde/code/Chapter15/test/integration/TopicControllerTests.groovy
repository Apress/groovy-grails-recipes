class TopicControllerTests extends GroovyTestCase {
  void testDelete() {
    def tc = new TopicController()
    tc.metaClass.redirect = { Map args -> return args}
    def groovy = new Forum(name:"Groovy",description:"General Groovy Discussion",
      lastPost: new Date())
    groovy.save(flush:true)
    Topic topic = new Topic(id: 1, subject: "sticky: Getting started with Groovy",
            message: "Message body", date: new Date(), forum:groovy)
    topic.save(flush:true)
    tc.params.id = '1'
    tc.delete()
    assertEquals tc.flash.message, "Sorry, you can't delete sticky topics"
    topic = new Topic(id: 2, subject: "Groovy JDBC question",
            message: "Message body", date:new Date(), forum:groovy)
    topic.save(flush:true)
    tc.params.id = '2'
    tc.delete()
    assertEquals tc.flash.message, "Topic 2 deleted"
    tc.params.id = '3'
    tc.delete()
    assertEquals tc.flash.message, "Topic not found with id 3"
  }
}