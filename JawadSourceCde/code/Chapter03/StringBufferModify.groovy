sb = new StringBuffer("StringBuffers are mutable")
sb.delete(sb.indexOf(" are mutable"),sb.size())
assert sb.toString() == "StringBuffers"
sb.insert(sb.size(), " are mutable")
assert sb.toString() == "StringBuffers are mutable"
sb.replace(sb.indexOf("StringBuffers"), "StringBuffers".size(), "StringBuilders")
assert sb.toString() == "StringBuilders are mutable"
def string = new String(sb)
def string2 = string.replaceAll("StringBuilders", "StringBuffers")
assert string2 == "StringBuffers are mutable"
