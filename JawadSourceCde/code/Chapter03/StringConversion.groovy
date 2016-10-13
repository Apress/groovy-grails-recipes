def object = new Object()
assert String.valueOf(object) == object.toString() //Objects
assert String.valueOf(true) == true.toString() //Booleans
assert String.valueOf('a') == 'a'.toString() //Characters
assert String.valueOf(1) == 1.toString() //Numbers
assert String.valueOf([a:1,b:2]) == [a:1,b:2].toString() //Collections
