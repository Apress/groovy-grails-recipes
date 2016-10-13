def map = [name:'Bashar',age:26,id:2000,active:true]
map.remove('name')
assert map == ["age":26, "id":2000, "active":true]
