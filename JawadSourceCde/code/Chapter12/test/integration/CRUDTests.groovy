/**
 * Created by IntelliJ IDEA.
 * User: Bashar
 * Date: Nov 24, 2008
 * Time: 11:44:56 PM
 * To change this template use File | Settings | File Templates.
 */
class CRUDTests extends GroovyTestCase {
    void testSave() {
        def forum = new Forum(name: "Groovy", description: "General Groovy Discussion",
                              lastPost: new Date())

        if (!forum.save()){
            fail(forum.errors.toString())
        }
    }

    void testSaveWithError(){
        def forum = new Forum(name:"Test",description:"Test")
        if (forum.save())
            fail("Should fail")
    }

    void testUpdate(){
        def forum = new Forum(name: "Groovy", description: "General Groovy Discussion",
                                     lastPost: new Date())
        forum.save(flush:true)
        def updateForum = Forum.findByName("Groovy")
        updateForum.setLastPost(new Date())
        if (!updateForum.save()){
            fail(updateForum.errors.toString())
        }
    }

    void testDelete(){
        Forum.list()*.delete()
        assert (Forum.list().isEmpty())
    }

    void testAddRelationships(){
      new Forum(name:"Groovy",description:"Groovy",lastPost:new Date())
     .addToTopics(new Topic(subject:"Subject 1",message:"Message 1",date:new Date()))
     .addToTopics(new Topic(subject:"Subject 2",message:"Message 2",date:new Date()))
    .save(flush:true)

        def forum = Forum.findByName("Groovy")
        assert forum.topics.size() == 2
    }

    void testRemoveRelationships(){
        new Forum(name:"Groovy",description:"Groovy",lastPost:new Date())
        .addToTopics(new Topic(subject:"Subject 1",message:"Message 1",date:new Date()))
        .addToTopics(new Topic(subject:"Subject 2",message:"Message 2",date:new Date()))
        .save(flush:true)
        def forum = Forum.findByName("Groovy")
        assert forum.topics.size() == 2        
        def topic1 = forum.topics.find{it.subject == 'Subject 1'}
        def topic2 = forum.topics.find{it.subject == 'Subject 2'}
        forum.removeFromTopics(topic1)
        forum.removeFromTopics(topic2)
        assert forum.topics.isEmpty()
    }


}