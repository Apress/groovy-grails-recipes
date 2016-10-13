def keys = []
def map = [name:'Bashar',age:"26",title:'Software Engineer',department:"26"]
map.findAll{it.value == '26'}.each{keys += it?.key}
assert keys == ["department", "age"]
