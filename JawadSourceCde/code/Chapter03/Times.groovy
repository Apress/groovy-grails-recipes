def start = 'a'
def result = ''
10.times{ 
   result += start++
}
assert result == new String('a'..'j' as char[])
