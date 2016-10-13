s = "The quick brown fox jumps over the lazy dog"
assert s.tokenize() == ['The','quick','brown','fox','jumps','over','the','lazy','dog']
assert s.tokenize() == new StringTokenizer(s).collect{it}
s1 = "The,quick*brown*fox,*jumps*over*the*lazy*dog"
assert s1.tokenize(',*') == s.tokenize()
