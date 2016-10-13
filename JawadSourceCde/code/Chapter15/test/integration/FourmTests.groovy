import grails.util.DomainBuilder

class ForumTests extends GroovyTestCase {

  void setUp() {
    def builder = new DomainBuilder()
    def groovyForum = builder.forum(name: "Groovy",
            description: "General Groovy Discussion", lastPost: new Date()) {
      topic(subject: "Groovy JDBC question",
              message: "How do I run a stored procedure in Groovy?",
              date: new Date()) {
        post(message: "Answer", date: new Date())
      }
      topic(subject: "Closures", message: "What are closures?",
              date: new Date()) {
        post(message: "Answer", date: new Date())
      }
    }
    if (!groovyForum.save(flush: true)) {
      fail(groovyForum.errors.allErrors[0].toString())
    }

    def grailsForum = builder.forum(name: "Grails",
            description: "General Grails Discussion", lastPost: new Date()) {
      topic(subject: "Dynamic finders",
              message: "How do I use dynamic finders?", date: new Date()) {
        post(message: "Answer", date: new Date())
      }
      topic(subject: "Content negotitation",
              message: "What is content negotiation?", date: new Date()) {
        post(message: "Answer", date: new Date())
      }
    }

    if (!grailsForum.save(flush: true)) {
      fail(grailsForum.errors.allErrors[0].toString())
    }
  }
  void testForum() {

    def forums = Forum.list()
    assert forums.size() == 2
    assertEquals forums[0].name, 'Groovy'
    assertEquals forums[1].name, 'Grails'

    def groovyForum = Forum.findByName("Groovy")
    assert groovyForum.topics.size() == 2
    groovyForum.topics.each {
      println it.subject //Will not output to the console
      assert it.subject == 'Groovy JDBC question' || it.subject == 'Closures'
    }
  }
}