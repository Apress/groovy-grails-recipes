//Creating a range
def range = 1..10
assert range == [1,2,3,4,5,6,7,8,9,10]
range = 'a'..'c'
assert range == ['a','b','c']

//Excluding the last element from a range
range = 1..<8
assert range == [1,2,3,4,5,6,7]

//Using a range with each method
(1..5).each{println it}

//Using a range to create a list (slicing)
assert [*1..4] == [1,2,3,4]
assert [1,*2..4] == [1,2,3,4]
