def map = [name:'Bashar',age:26,id:2000,active:true]
assert map.name == 'Bashar'
assert map['name'] == 'Bashar'
assert map.get('name') == 'Bashar'
assert map.getAt('name') == 'Bashar'
