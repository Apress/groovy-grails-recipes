def map = [name:'Bashar',age:26,id:2000,active:true]
assert map.title == null
assert map.get('title','Software Engineer') == 'Software Engineer'
