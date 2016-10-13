class MethodsExamples {
  def sum(arg1,arg2,arg3 = 1){
    return arg3 * (arg1 + arg2) 
  }
}
def a = new MethodsExamples()
assert a.sum(1,2,-1) == -3
assert a.sum(1,2) == 3
