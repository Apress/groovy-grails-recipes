//GroovyListClass.groovy
package com.apress.groovygrailsrecipes.chap04

class GroovyList extends ArrayList {
  public GroovyList(){
  }
  String newGroovyMethod(){
    return 'New Groovy Method'
  }
}
GroovyList list = new GroovyList()
assert list.newGroovyMethod() == 'New Groovy Method'