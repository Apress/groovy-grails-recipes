//Converts all occurences of the word Groovy to upper case 
"Hello GROOVY, GROOVY rocks" == "Hello Groovy, Groovy rocks"
  .replaceAll("Groovy") {Object[] it ->it[0].toUpperCase()}
