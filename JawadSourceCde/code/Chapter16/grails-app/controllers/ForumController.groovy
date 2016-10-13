import grails.converters.*

class ForumController {

  def index = {}
  def showForums = {
    def forums = Forum.list()
    render forums as XML
  }

  def showTopics = {
    def topics = []
    if (params.id) {
      def forum = Forum.findByName(params.id)
      if (forum) {
        forum.topics.each {
          topics += it
        }
      }
    }
    if (!topics) {
    //No forum parameter passed or forum not found
      def forums = Forum.list()
      for (forum in forums) {
        topics += forum.topics
      }
    }
    withFormat {
      xml {render topics as XML}
      json {render topics as JSON}
    }

  }
}
