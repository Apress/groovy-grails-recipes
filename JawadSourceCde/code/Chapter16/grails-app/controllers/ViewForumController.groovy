class ViewForumController {
  def uploadService

  def index = {redirect(action:"upload")}

  def submit = {
    Topic topic = new Topic(params['topic'])
    if (!topic.myFile.empty) {
      uploadService.upload(topic.myFile)
    }
    if (topic.save())
      render "success"
    else
      render topic.errors
  }

  //This action is a little different from what's in the book to facilitate testing it
  def submitREST = {
    def topic = new Topic()
    topic.properties = params
    topic.forum = Forum.findByName(params.forum)        
    if (topic.save()) {
      response.status = 201
      render topic.id
    }
    else {
      response.sendError(400)
    }
  }
  

    def upload = {
        
    }
}