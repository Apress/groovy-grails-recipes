class MethodsAsClosures{
  def toLowerCase(text){
    text.toLowerCase();
  }
}
def methodsAsClosures = new MethodsAsClosures()
def toLowerCase = methodsAsClosures.&toLowerCase
assert toLowerCase("Groovy") == "groovy"
assert toLowerCase ("Groovy") == methodsAsClosures.toLowerCase("Groovy")
