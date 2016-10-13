list1 = []; list2 = [];list3 = []
for (element in 0..9){
  list1 += element
  list2 += element + 1
  list3 += (list1[element] + list2[element]) / 2
}
list3.each{
  println it
}
