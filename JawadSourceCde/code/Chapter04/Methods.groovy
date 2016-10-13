class MethodsExample {
  public String returnIsOptional() {
    "return keyword is optional"
  }
  def returnTypeisOptional() {
    return "return type is optional"
  }
   def parameterTypesAreOptional(x,y){
     return "first argument is $x, second argument is $y"
   }
   String defaultIsPublic(){
     println "default is public"
   }
 }
def methods = new MethodsExample()
assert methods.returnIsOptional() == "return keyword is optional"
assert methods.returnTypeisOptional() == "return type is optional"
assert methods.parameterTypesAreOptional(1,2) == 
  "first argument is 1, second argument is 2"
methods.defaultIsPublic()
