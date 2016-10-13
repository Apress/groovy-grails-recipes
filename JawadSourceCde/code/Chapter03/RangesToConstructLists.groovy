def list = ('a'..'z').toList()
list[list.indexOf('a')..list.indexOf('y')] = 'a'
assert list == ['a','z']
