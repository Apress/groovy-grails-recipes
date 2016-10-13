text = "Information technology revolution"
pattern = /\b\w*ion\b/  //Pattern: a word that ends with the letters 'ion'
assert text =~ pattern
def matched = []
//Find all matches of the pattern
text.eachMatch(pattern) { match -> matched += match[0] } 
println matched
assert matched.size() == 2
assert matched[0] == "Information"
assert matched[1] == "revolution"
