def a = [] //Empty list
a += [1,2,3] //Adding elements to a list
assert a == [1,2,3]
assert a.size == 3
a << 4 << 5 //Another way of adding elements to a list
assert a == [1,2,3,4,5]
a.add(6) //A third way of adding elements to a list
assert a == [1,2,3,4,5,6]

//Accessing elements of a list
assert a[0] == 1 //Using a subscript
assert a.get(0) == 1 //Using get
assert a.getAt(0) == 1 //Using getAt
assert a[-1]  == 6 //Last element index starts at -1 backwards

//Modifying elements in a list
a.putAt(1,1)
assert a == [1,1,3,4,5,6]
assert a.set(1,2) == 1 //Will return the old value
assert a == [1,2,3,4,5,6]

//Iterating over a list
a.each{ println "$it"}
//Printing items in a list with their index
a.eachWithIndex{it, index -> println item : "$it", index : "$index"}

//Removing items from a list
a -= 1 //Remove number 1
assert a == [2,3,4,5,6]
a = a.minus([2,3,4]) //Remove the sublist [2,3,4]
assert a == [5,6]
