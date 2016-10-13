package com.apress.groovygrailsrecipes.chap04;

public class JavaList extends GroovyList{
  public static void main (String[] args){
    JavaList javaList = new JavaList();
    assert javaList.newJavaMethod().equals
      ("New Groovy Method called from newJavaMethod");
  }
    public String newJavaMethod(){
    return super.newGroovyMethod()+" Called from newJavaMethod";
  }
}
