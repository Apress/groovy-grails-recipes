//Creating a map
def map = ['name':'Bashar','age':26,skills:['Java','Groovy'], 'author':true]
assert map.size() == 4

//Adding a key/value pair to a map
map += ['city':'Tucson']
assert map == ['name':'Bashar','age':26,skills:['Java','Groovy'],
               'author':true, 'city':'Tucson']
//Alternative way of adding a key/value pair to a map
map['state'] = 'AZ'
assert map == ['name':'Bashar','age':26,skills:['Java','Groovy'],
               'author':true, 'city':'Tucson', 'state':'AZ']
//Accessing map elements
assert map.city == 'Tucson'
assert map['city'] == 'Tucson'
assert map.get('city') == 'Tucson'
assert map.getAt('city') == 'Tucson'
assert map.skills[0] == 'Java'

//Keys are unique
assert ['name':'Bashar','name':'Abdul'] == ['name':'Abdul']

//Iterating over a map
map.each{ it -> println it.key + ":" + it.value}
map.eachWithIndex{ it, index -> println "item $index - " + it.key + ":" + it.value}
