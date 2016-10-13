class TopicController {
  def scaffold = Topic
  def delete = {
    Topic topic = Topic.get(params.id)
    if (!topic) {
      flash.message = "Topic not found with id ${params.id}"
      redirect(action: 'list')
    }
    else if (topic.subject.toLowerCase().contains('sticky')) {
      flash.message = "Sorry, you can't delete sticky topics"
      redirect(action: 'list', model: [topic: topic])
      return
    }
    else {
      topic.delete()
      flash.message = "Topic ${params.id} deleted"
      redirect(action: 'list')
    }
  }
}