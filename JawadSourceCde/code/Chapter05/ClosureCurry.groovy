def original = {x,y,z -> return x + y + z}
def addOne = original.curry(1)
assert addOne(1,1) == 3
def addTwo = addOne.curry(1)
assert addTwo(1) == 3
