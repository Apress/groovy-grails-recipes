class CriteriaTests extends GroovyTestCase {

    def groovy, grails

    void setUp() {
        groovy = new Forum(name: "Groovy", description: "Groovy Forum", lastPost: new Date() - 7)
        groovy.addToTopics(new Topic(subject: "Subject 1", message: "Groovy message", date: new Date()))
        groovy.addToTopics(new Topic(subject: "Subject 2", message: "Message 2", date: new Date()))
        groovy.save()

        grails = new Forum(name: "Grails", description: "Grails Forum", lastPost: new Date() - 2)
        grails.addToTopics(new Topic(subject: "JDBC", message: "Message 1", date: new Date()))
        grails.addToTopics(new Topic(subject: "Subject 2", message: "JDBC", date: new Date()))
        grails.save(flush: true)
    }

    void testCriteria() {
        def c = Forum.createCriteria()
        def results = c.listDistinct {
            or {
                ilike("description", "%Groovy%")
                topics {
                    between("date", new Date() - 10, new Date())
                }
            }
        }
        assertEquals results, [groovy, grails]

    }

    void testProjection() {
        def c = Forum.createCriteria()
        def results = c.list {
            projections {
                countDistinct('name')
            }
            topics {
                between("date", new Date() - 10, new Date())
            }
        }

        assertEquals results,[2]

    }

    void testScrollableResults() {
        def c = Forum.createCriteria()
        def results = c.scroll {
            maxResults(10)
            projections {
                countDistinct('name')
            }
            topics {
                between("date", new Date() - 10, new Date())
            }
        }

        results.first()
        assertEquals results.get(0),2

    }

}