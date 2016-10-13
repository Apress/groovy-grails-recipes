def map = [name:'Bashar',age:26,id:2000,active:true]
map.active = false
map.id = map.id - 1000
assert map == ["name":"Bashar", "age":26, "id":1000, "active":false]
