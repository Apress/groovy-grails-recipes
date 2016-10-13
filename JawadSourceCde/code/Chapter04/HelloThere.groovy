//HelloThere.groovy:
class HelloWorld {
  def sayHello(){
    Echoer echoer = new Echoer()
    echoer.echo()
  }
}
class Echoer {
  def echo(){
    println 'Hello World'
  }
}
