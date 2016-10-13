
class QueryTests extends GroovyTestCase {

    void setUp(){
           def groovy = new Forum(name: "Groovy", description: "General Groovy Discussion",
                              lastPost: new Date())
           groovy.save()
           def grails = new Forum(name: "Grails", description: "General Grails Discussion",
                              lastPost: new Date())
           grails.save()
    }

    void testList(){
        def names = []
        Forum.listOrderByName().each{ forum ->
            names += forum.name
        }        
        assertEquals (names,["Grails","Groovy"])
    }       

    void testCount(){
        assertEquals Forum.count(),2
    }

}