sb = new StringBuffer("abcdefg")
assert sb[0] == 'a'
assert sb[2..4] == 'cde'
assert sb[0].class == String
assert sb[-6..-4] == "bcd"
sb[0..2] = "xyz"
assert sb.toString() == "xyzdefg"
