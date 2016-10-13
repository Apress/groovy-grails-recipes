class MethodsExamples {
  def sum(List args){
    def count = 0
    args.each{count += it}
    return count
  }
}
MethodsExamples a = new MethodsExamples()
assert a.sum([1,2,3]) == 6
assert a.sum([1,2]) == 3
