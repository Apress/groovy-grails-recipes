package com.apress.groovygrailsrecipes.chap04;

public class HelloWorldTest {
  public static void main (String[] args){
    HelloWorld helloWorldEnglish = new HelloWorldEnglish();
    HelloWorld helloWorldSpanish = new HelloWorldSpanish();
    assert helloWorldEnglish.sayHello().equals("Hello World");
    assert helloWorldSpanish.sayHello().equals("Hola Mundo");
  }
}
