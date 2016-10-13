class ViewForumController {
  def index = {}
  def viewTopic = {
    def topics = session."${params.forumName}"
    topics.each {
      if (it.subject == params.subject) {
        render """
          subject: $params.subject<br/><br/>
          $it.message
        """
      }
    }
  }
  def compose = {
  }

  def submit = {
    if (!session."${params.forumName}"){
      session."${params.forumName}" = []
    }
    PostCommand post = new PostCommand(params['post'])

    if(!post.myFile.empty) {
      post.myFile.transferTo( new File('C:\\temp\\uploads\\' +
              post.myFile.originalFilename))
    }
    session."${params.forumName}" += post
    render "Your message was posted successfully"
  }




  def success = {
    def message = "Your message in $chainModel.forumName has been posted"
    chain(action: index, model: [:],
            params: [message: message, forumName: chainModel.forumName])
  }

}

class PostCommand {
  def myFile
  String subject
  String message
}

