def list = []
('a'..'z').each{
    list += it
}
assert list == ('a'..'z').toList()
