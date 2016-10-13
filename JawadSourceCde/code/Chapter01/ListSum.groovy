class ListSum{
  public static int sum(list){
    def result = 0
    list.each{
      result += it
    }
    return result
  }
}

a = [1,2,3,4,5]
println ListSum.sum(a)