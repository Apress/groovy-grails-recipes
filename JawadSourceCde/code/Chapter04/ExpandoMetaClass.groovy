String.metaClass.capitalize = {->    
if (delegate.size() == 0) return ""
    if (delegate.size() == 1) return delegate.toUpperCase()
    return delegate[0].toUpperCase() + delegate[1..delegate.length() - 1]
}

assert "hello there".capitalize() == "Hello there"
assert "".capitalize() == ""
assert "s".capitalize() == "S"
