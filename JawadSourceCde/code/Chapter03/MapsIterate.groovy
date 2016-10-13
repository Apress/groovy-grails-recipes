StringBuffer sb = new StringBuffer()
def map = [name:'Bashar',age:26,id:2000,active:true]
map.each{sb += it.key + ":" + it.value + ","}
assert sb.toString() == "name:Bashar,age:26,id:2000,active:true,"
