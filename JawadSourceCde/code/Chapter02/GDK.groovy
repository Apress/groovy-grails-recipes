//java.lang.Object
def a = [1,2,3]
assert a.any {it > 2} //At least one element satisfies the condition
assert a.every{it > 0} //All elements must satisfy the condition
//Iterate over all the elements calling the closure on each item
assert a.collect{it * 2} == [2,4,6] 
assert a.findAll{it > 2} == [3] //Finds all elements that satisfy the condition
a.print(a) //Prints the values of a, can be also written as print(a)

//java.lang.Number
def x = 10
assert x.abs() == 10 //Returns absolute value
assert x.compareTo(3) == 1 //Compares two numbers
assert x.div(2) == 5 //Divides two numbers
def total = 0
x.downto(5) {
number -> total += number} //Sums the numbers from 10 to 5 inclusive
assert total == 45 
total = 0
x.upto(15){
number -> total += number} //Sums the numbers from 10 to 15 inclusive
assert total == 75

//java.io.File
def f = new File("C:\\temp\\groovy.txt") //Marks a file for creation
f.text = "Groovy rocks!" //File will be created if it doesn't exist
assert f.exists()
assert f.text == "Groovy rocks!"
f.append("Doesn't?") //Appends text to the file
assert f.text =="Groovy rocks!Doesn't?"
f.renameTo(new File("C:\\temp\\groovyRenamed.txt")) //Renames a file
assert f.name == "groovy.txt" //Files are immutable
[new File("C:\\temp\\groovy.txt"),new File("C:\\temp\\groovyRenamed.txt")].
each{it.delete()} //Deletes both files
