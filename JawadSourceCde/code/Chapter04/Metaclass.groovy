println Object.metaClass.methods //Returns all methods in java.lang.Object
def a = [1,2,3]
println a.metaClass.methods //Returns all methods in java.util.List
println a.metaClass.metaMethods //Returns all methods injected by the
                               //GKDK in java.util.List
println java.io.File.metaClass.properties //Returns all meta
                      //preoprties in the java.io.File class

class Meta{
    String property
    def noArgs() {"method 1"}
    def printMe(String arg1) {println "method 2 with $arg1"}
    def abs(Integer arg1){arg1.abs()}
}

def meta = new Meta()

assert meta.metaClass.respondsTo(meta, "noArgs") 
assert meta.metaClass.respondsTo(meta, "printMe")
assert meta.metaClass.respondsTo(meta, "printMe", String)
assert !meta.metaClass.respondsTo(meta, "printMe", Integer)
assert meta.metaClass.respondsTo(meta, "abs", Integer)
assert meta.metaClass.hasProperty(meta, "property")
