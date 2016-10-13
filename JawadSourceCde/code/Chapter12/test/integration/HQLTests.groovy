
class HQLTests extends GroovyTestCase {
      def groovy,grails

    void setUp() {
        groovy = new Forum(name: "Groovy", description: "Groovy Forum", lastPost: new Date() - 8)
        groovy.addToTopics(new Topic(subject: "Subject 1", message: "Groovy message", date: new Date() - 8))
        groovy.addToTopics(new Topic(subject: "Subject 2", message: "Message 2", date: new Date() - 10))
        groovy.save()

        grails = new Forum(name: "Grails", description: "Grails Forum", lastPost: new Date() - 2)
        grails.addToTopics(new Topic(subject: "JDBC", message: "Message 1", date: new Date()))
        grails.addToTopics(new Topic(subject: "Subject 2", message: "JDBC", date: new Date()))
        grails.save(flush:true)
    }



    void testHQL(){
        def results = Forum.findAll("from Forum as f where f.name like 'G%' ")
        assertEquals results.size(), 2
        results = Forum.executeQuery(
          "select distinct f From Forum f join f.topics t where t.date > :date",
          [date:new Date() - 7] ,[max:10, offset:0])
        assertEquals results, [grails]

    }
    


}