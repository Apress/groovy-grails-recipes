assert 'a' < 'b'
assert 'a' > 'A'
assert 'a'.compareTo('b') == -1
assert 'a'.compareToIgnoreCase('A') == 0
