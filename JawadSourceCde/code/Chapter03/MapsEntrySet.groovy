def map = ['a':1,'b':2,'c':3]
map.entrySet().collect{
    assert it.key in ['a','b','c']
    it.value += 2
}
assert map == ["a":3, "b":4, "c":5]
