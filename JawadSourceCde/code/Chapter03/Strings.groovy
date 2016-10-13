s1 = "Hello \"World\" " //Escape double quotes
s2 = 'Hello "World" '
assert s1 == s2
s3 = 'Hello \'World\' ' //Escape single quotes
s4 = "Hello 'World' "
assert s3 == s4
assert new String('Hello World') == "Hello World"
def s = ['h','e','l','l','o'] as char[]
assert new String(s) == 'hello'
assert new String(s,0,4) == 'hell'
s.eachWithIndex{ch,index -> assert ch == s[index]}
assert 'hello'.toCharArray() == ['h','e','l','l','o']
