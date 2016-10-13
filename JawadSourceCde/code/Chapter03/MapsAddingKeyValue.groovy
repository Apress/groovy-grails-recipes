def map = [name:'Bashar',age:26,id:2000,active:true]
map["title"] = 'Software Engineer'
map.put("city","Tucson")
map.putAt("state","AZ")
assert map == ["name":"Bashar", "age":26, "id":2000, "active":true,
                "title":"Software Engineer", "city":"Tucson", "state":"AZ"]
