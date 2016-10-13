class ViewForumController {

    def index = {render "All users"}

    def compose = {render "Authenticated users only"}
    def submit = {render "Authenticated users only"} 
}
