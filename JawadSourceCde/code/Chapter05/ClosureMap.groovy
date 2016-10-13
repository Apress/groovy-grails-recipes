key = {value -> println value}
def m = [(key):5]
assert m[key] == 5
assert m.get(key) == 5
assert m.key == null

def value = {println 'value'}
def m2 = [key : value]
m2.key.call()
