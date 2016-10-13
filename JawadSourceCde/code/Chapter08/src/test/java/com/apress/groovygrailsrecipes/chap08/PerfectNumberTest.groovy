package com.apress.groovygrailsrecipes.chap08

import com.apress.groovygrailsrecipes.chap08.PerfectNumber

class PerfectNumberTest extends GroovyTestCase {
  def perfectNumber
  void setUp(){
    perfectNumber = new PerfectNumber()
  }
  void testIsPerfect(){
    assertFalse perfectNumber.isPerfect(4)
  }
  void testIsPerfect2(){
  assertTrue perfectNumber.isPerfect(6)
 }
  void testIsPerfect3(){
  assertTrue !perfectNumber.isPerfect(-1)
  }

}
