class MOP {
    def list
    def getProperty(String name) { println "The list is $list" }
    def invokeMethod(String name, args){
        if (name.startsWith("findAllStartsWith")){
             String startsWith = name[-1]
             return list.findAll{it.startsWith(startsWith)}
        }

    }
}
def mop = new MOP(list:["Groovy","is","Great", "isn't"])
assert mop.findAllStartsWithG() == ["Groovy","Great"]
assert mop.findAllStartsWithi() == ["is","isn't"]
assert mop.findAllStartsWithZ() == []
println mop.list //Prints: The list is ["Groovy", "is", "Great", "isn't"]
