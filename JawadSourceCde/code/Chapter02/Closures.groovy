//Simple closure with no arguments
def clos1 = { println "hello world!" }
//Calling the closure
clos1()

//A closure with arguments
def clos2 = {arg1,arg2 -> println arg1+arg2}
clos2(3,4)

//A closure defined inside a method. The closure is bound to the
//variables within its scope
def method1(book){
    def prefix = "The title of the book is: "
    return {println prefix + book}
}

def clos3 = method1("Groovy")
clos3()
