a = ('a'..'z').toList()
assert a.find{it > 'x'} == 'y'
assert a.findAll{it > 'x'} == ['y','z']
assert a.every{it > 'A'}
assert a.any{it > 'c'}
