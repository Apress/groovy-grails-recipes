def closure = {int a, b -> a + b}
c = closure
assert c.getMaximumNumberOfParameters() == 2
def params = closure.getParameterTypes()
assert params[0] in int
assert params[1] as Object
