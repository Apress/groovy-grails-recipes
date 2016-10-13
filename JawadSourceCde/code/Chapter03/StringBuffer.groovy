def sb = new StringBuffer('Hello World')
assert sb.toString() == 'Hello World'
sb.length = 5
assert sb.toString() == 'Hello'
assert sb.substring(0,2) == 'He'
//Use <<, append(String) or leftShift(String) to append to a StringBuffer.
//Using + to append to a StringBuffer will return a String
sb = new StringBuffer("Hello")
assert sb + ' World' in java.lang.String
assert sb << ' World' in java.lang.StringBuffer
assert sb.toString() == ("Hello World")
assert sb.append(", Groovy rocks").toString() == "Hello World, Groovy rocks"
assert sb.leftShift(". Doesn't?").toString() == "Hello World, Groovy rocks. Doesn't?"
