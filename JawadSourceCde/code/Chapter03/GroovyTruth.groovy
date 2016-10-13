assert true//Boolean
assert !false

assert 'Hello World' == /Hello World/ //A matcher must find a match
assert !('hello World' == /Hello World/)

assert "Hello" //A string must be nonempty
assert !""

assert 1 //A number must be nonzero
assert !0

assert new Object() //An object must be non-null
assert !null
