for (i in 0..10)   //Iterate over a range
    println i

for (i in [1,2,3,4]) //Iterate over a list
    println i

x = new Integer[3]
x[0] = 0; x[1] = 1; x[2] = 2

for (i in x) //Iterate over an array
    println i
    
map = [name:'Bashar', age:26, city: 'Tucson', state:'AZ']

for (entry in map) //Iterate over a map
  println entry.key + ' ' + entry.value

for (i in 'Hello')//Iterate over a string
    println i
