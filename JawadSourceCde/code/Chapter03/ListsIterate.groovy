total = 0
a = [1,2,3]
b = []
a.each{ total += it}
assert total == 6
a.eachWithIndex{it, index -> b[index] = a[index]}
assert a == b
