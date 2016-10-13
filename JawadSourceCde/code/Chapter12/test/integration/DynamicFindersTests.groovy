class DynamicFindersTests extends GroovyTestCase {


    def groovy,grails

    void setUp() {
        groovy = new Forum(name: "Groovy", description: "Groovy Forum", lastPost: new Date() - 7)
        groovy.addToTopics(new Topic(subject: "Subject 1", message: "Groovy message", date: new Date()))
        groovy.addToTopics(new Topic(subject: "Subject 2", message: "Message 2", date: new Date()))
        groovy.save()

        grails = new Forum(name: "Grails", description: "Grails Forum", lastPost: new Date() - 2)
        grails.addToTopics(new Topic(subject: "JDBC", message: "Message 1", date: new Date()))
        grails.addToTopics(new Topic(subject: "Subject 2", message: "JDBC", date: new Date()))
        grails.save(flush:true)
    }

    void testDynamicFinders() {
        //Find a forum with the name "Groovy"
        assertEquals(Forum.findByName("Groovy"), groovy)

        //Find a forum where the name starts with "G"
        assertEquals(Forum.findAllByNameLike("G%"),[groovy,grails])

        //Find all forums where the name starts with "G" using pagination
        assertEquals (Forum.findAllByNameLike("G%", [max: 5, offset: 0, sort: "name", order: "desc"]),[groovy,grails])

        //Find all forums where the last post date is greater than date1
        def date1 = new Date()
        assertEquals Forum.findAllByLastPostGreaterThan(date1), []

        def date2 = new Date() - 4
        //Find all forums where the last post date is between date1 and date 2
        assertEquals Forum.findAllByLastPostBetween(date2, date1),[grails]

        date1 = new Date() - 3
        //Find a forum where the name equals "Groovy" and the last post date is less than date
        assertEquals Forum.findAllByNameAndLastPostLessThan("Groovy", date1),[groovy]

        //Find all topics in the forum "Groovy"
        def topics = []
        def forums = Forum.findAllByName("Groovy")
        for (forum in forums){
            topics += forum.topics
        }
        assertEquals topics.size(),2

        //Find all topics where the subject or the message field contains "JDBC"
        topics = Topic.findAllBySubjectLikeOrMessageLike("JDBC", "JDBC")
        assertEquals topics.size(),2
        topics[0].forums.each{ forum ->
            assertEquals forum.name,"Grails"

        }

        //Find all topics where the subject is null
        assertEquals Topic.findAllBySubjectIsNull(),[]

        //Find all topics where the message is not null
        assertEquals Topic.findAllByMessageIsNotNull().size(),4

        //Find all topics where the message contains "groovy" case insensitive and the post date is greater than date
        date1 = new Date() - 10
        topics = Topic.findAllByMessageIlikeAndDateGreaterThan("%groovy%", date1)
        assertEquals topics.size(), 1
        assertEquals topics[0].message, "Groovy message"
    }

}