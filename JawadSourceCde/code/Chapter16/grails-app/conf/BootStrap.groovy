class BootStrap {

     def init = { servletContext ->
         def user = new User(name:"demo",password:"demo",numberOfLogins:0)
         user.save(flush:true)
     }
     def destroy = {
     }
} 