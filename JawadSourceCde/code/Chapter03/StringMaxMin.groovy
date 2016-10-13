Collections.max('abcdeF'.toList()) == 'e'
assert Collections.max('abcdeF'.toList(), String.CASE_INSENSITIVE_ORDER) == 'F'
assert Collections.min(['abc','abd','abe']) == 'abc'    
assert Collections.min(['Abc','aBd','abE'], String.CASE_INSENSITIVE_ORDER) == 'Abc'
