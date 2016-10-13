def text = "Welcome to Groovy" 
//Both methods return the size of a String
assert text.size() && text.length() == 17 
assert text.substring(0,7) == "Welcome" 
assert text.contains("Welcome")
//Count number of occurences of a word in a String
assert text.count("Welcome") == 1
text += "\nWhat a great language"
//Decide whether a String can be parsed as a number or not
assert text.isNumber() == false
//Reverse a String
assert text.reverse() =="egaugnal taerg a tahW\nyvoorG ot emocleW"
assert text.findAll{it > 'w'} == ['y'] //Finds all characters greater than 'w'
assert text.replace('Groovy','Java') == 'Welcome to Java\nWhat a great language'
