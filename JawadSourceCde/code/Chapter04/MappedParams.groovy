class MethodsExamples {
  def sum(Map args){
    def count = 0
    args.each{
      count += it.value
    }
    return count
  }
}
MethodsExamples a = new MethodsExamples()
assert a.sum(a:1, b:2) == 3
assert a.sum(a:1, b:2, c:3) == 6
assert a.sum(a:1) == 1
