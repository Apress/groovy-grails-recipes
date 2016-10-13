class TopicControllerUTests extends GroovyTestCase {

  void testDelete() {

    //Mock the static get method
    Topic.metaClass.static.get = {Long id ->
      if (id == 1) //Sticky topic
        return new Topic(id: id,
          subject: "sticky: Getting started with Groovy", message: "Message body")
      else if (id == 2) //Non sticky topic
        return new Topic(id: id,
          subject: "Groovy JDBC question", message: "Message body")
      else
        return null
    }
    //Mock the static delete method
    Topic.metaClass.static.delete = {
      new Topic(id: -1, message: "", subject: "")
    }

    def flash = [:]
    //Mock the flash object
    TopicController.metaClass.getFlash = {-> flash}

    //Mock the redirect action
    TopicController.metaClass.redirect = {action ->
      return action
    }

    //Sticky topic test
    TopicController.metaClass.getParams = {-> [id: 1]}
    def controller = new TopicController()
    controller.delete()
    assertEquals flash.message,"Sorry, you can't delete sticky topics"

    //Non Sticky topic test
    TopicController.metaClass.getParams = {-> [id: 2]}
    controller = new TopicController()
    controller.delete()
    assertEquals flash.message,"Topic 2 deleted"

    //Topic not found
    TopicController.metaClass.getParams = {-> [id: 3]}
    controller = new TopicController()
    controller.delete()
    assertEquals flash.message,"Topic not found with id 3"
  }
}