assert 'hello' + ' world' - 'l' == 'helo world' //Subtracts at most one l
assert ('Today is Sunday' - 'Sunday').trim() == 'Today is'
assert 'hello ' * 2 == 'hello hello '
def empty = []
assert 'abc'.each{empty << it} == 'abc'
assert 'abc'.next() == 'abd'
assert 'abc'.previous() == 'abb'
