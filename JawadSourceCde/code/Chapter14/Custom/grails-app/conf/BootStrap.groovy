class BootStrap {

     def init = { servletContext ->

         def user = new User(name:"demo",password:"demo")
         user.save()
     }
     def destroy = {
     }
} 