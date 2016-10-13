def list = [1,2,3]
list = list.collect{it * it}
assert list == [1,4,9]
assert list.collect{Math.sqrt(it)} == [1,2,3]
