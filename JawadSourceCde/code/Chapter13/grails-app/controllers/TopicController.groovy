class TopicController {

    def index = { redirect(action: list, params: params) }

    // the delete, save and update actions only accept POST requests
    def allowedMethods = [delete: 'POST', save: 'POST', update: 'POST']

    def list = {
        if (!params.max) params.max = 10
        [topicList: Topic.list(params)]
    }

    def show = {
        def topic = Topic.get(params.id)

        if (!topic) {
            flash.message = "Topic not found with id ${params.id}"
            redirect(action: list)
        }
        else { return [topic: topic] }
    }

    def edit = {
        def topic = Topic.get(params.id)

        if (!topic) {
            flash.message = "Topic not found with id ${params.id}"
            redirect(action: list)
        }
        else {
            return [topic: topic]
        }
    }


    def update = {
        def topic = Topic.get(params.id)
        if (flash.rating)
            topic.rating = Integer.parseInt(flash.rating)
        if (topic) {
            topic.properties = params
            if (!topic.hasErrors() && topic.save()) {
                flash.message = "Topic ${params.id} updated"
                redirect(action: show, id: topic.id)
            }
            else {
                render(view: 'edit', model: [topic: topic])
            }
        }
        else {
            flash.message = "Topic not found with id ${params.id}"
            redirect(action: edit, id: params.id)
        }
    }

    def create = {
        def topic = new Topic()
        topic.properties = params
        return ['topic': topic]
    }

    def save = {
        def topic = new Topic(params)
        if (flash.rating)
        topic.rating = Integer.parseInt(flash.rating)
        if (!topic.hasErrors() && topic.save()) {
            flash.message = "Topic ${topic.id} created"
            redirect(action: show, id: topic.id)
        }
        else {
            render(view: 'create', model: [topic: topic])
        }
    }

    def delete = {
        Topic topic = Topic.get(params.id)
        if (topic.subject.toLowerCase().contains('sticky')) {
            topic.errors.reject("topic.sticky.delete")
            render(view: 'list', model: [topic: topic, topicList: Topic.list(params)])
            return
        }
        if (topic) {
            topic.delete()
            flash.message = "Topic ${params.id} deleted"
            redirect(action: list)
        }
        else {
            flash.message = "Topic not found with id ${params.id}"
            redirect(action: list)
        }
    }
    def rate = {
        flash.rating = params.rating
        render(template: "/rate", model: [rating: flash.rating, controller: "topic"])
    }
}


