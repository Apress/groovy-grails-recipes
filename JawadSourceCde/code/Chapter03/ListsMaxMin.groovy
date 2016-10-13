a = [1,2,3,10,4]
assert a.max() == 10 
assert Collections.max(a) == 10 //Another way to find max
assert a.min() == 1
assert Collections.min(a) == 1 //Another way to find min
a = ['a','b','c', 'Hello']
assert a.min() == 'Hello' //Compare using ASCII representation
assert a.max() == 'c'
