// webtest/tests/TopicTest.groovy
class TopicTest extends grails.util.WebTest {

    // Unlike unit tests, functional tests are often sequence dependent.
    // Specify that sequence here.
    void suite() {
        testTopicDelete()
        // add tests for more operations here
    }

    def testTopicDelete() {
        webtest('Testing TopicController delete action') {

            //Create a new Forum
            invoke      'forum'
            verifyText  'Home'
            clickLink   'New Forum'
            verifyText  'Create Forum'
            setInputField 'Groovy', name:'name'
            setInputField 'General Groovy Discussion', name:'description'
            clickButton 'Create'
            verifyText  'Show Forum', description:'Show Forum page'

            clickButton 'Edit', description:'Edit to add new topics'
            clickLink   'Add Topic'

            //Sticky topic
            setInputField 'sticky: Getting started with Groovy', name:'subject'
            setInputField 'Message body', name:'message'
            clickButton 'Create'
            verifyText  'Show Topic', description:'Show Topic page'
            clickButton 'Delete', description: 'Attempting to delete a sticky topic'
            verifyText 'Sorry, you can\'t delete sticky topics'

            //Non Sticky topic
            clickLink   'New Topic', description:'Create a non sticky topic'
            setInputField 'Groovy JDBC question', name:'subject'
            setInputField 'Message body', name:'message'
            clickButton 'Create'
            verifyText  'Show Topic', description:'Show Topic page'
            clickButton 'Delete',
              description: 'Attempting to delete a non sticky topic'
            verifyXPath xpath:  "//div[@class='message']",
                            text:   /.*Topic.*deleted.*/,
                            regex:  true
          //Topic not found
          invoke  'topic/delete/-1'
          verifyText  'Topic not found with id -1'
        }
    }
}