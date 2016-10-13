//HelloWorld2.groovy:
class HelloThere {
  String sayHello(){
    Echoer echoer = new Echoer()
      echoer.echo()
  }
}
class Echoer {
  String echo(){
    return 'Hello World'
  }
}
def helloThere = new HelloThere()
assert helloThere.sayHello() == 'Hello World'
