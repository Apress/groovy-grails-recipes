assert 'hello'[1] == 'e'
assert 'hello'[2..'hello'.size() - 1] == 'llo'
assert 'hello'[0,2,4] == 'hlo'
assert 'hello'[-4,-2] == 'el'
