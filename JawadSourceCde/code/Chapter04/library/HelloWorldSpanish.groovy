import library.HelloWorld as HelloWorldEnglish
class HelloWorld extends HelloWorldEnglish {
  public String sayHello(){
    return 'Hola Mundo'
  }
}
HelloWorld helloWorld = new HelloWorld()
assert helloWorld.sayHello() == 'Hola Mundo'
