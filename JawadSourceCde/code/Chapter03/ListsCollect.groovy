a = [1,2,3]
b = a.collect{it * 10}
assert b == [10,20,30]
