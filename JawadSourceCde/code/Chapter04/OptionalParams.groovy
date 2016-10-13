class MethodsExamples {
  def sum(def arg1, arg2, Object[] optionals){
  if (optionals)
    return arg1 + arg2 + optionals.toList().sum()
  else
    return arg1 + arg2        
  }
}
MethodsExamples a = new MethodsExamples()
assert a.sum(1,1) == 2
assert a.sum(1,1,1) == 3
assert a.sum(1,1,1,1) == 4
