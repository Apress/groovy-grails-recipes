int x = 1
new GroovyTestCase().shouldFail(ClassCastException.class){
  x = 'hi'
}
