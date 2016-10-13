class Node{
  String value
  boolean isContainer    
  boolean isRoot
  def String toString(){
    return value
  }
}
class JSONBuilder extends BuilderSupport{   
  def output = new StringBuffer("{\n")
  def createNode(Object name){
    return createNode(name, null, null)
  }
  def createNode(Object name,Object value){
    return createNode(name, null, value)
  }
  def createNode(Object name,Map attrs){
    return createNode(name, attrs, null)
  }
  def createNode(Object name, Map attrs,Object value){
    def node = new Node()
    if (!current) node.isRoot = true
    if (!node.isRoot){
      if (!node.isRoot && value != null){ 
        output << """"$name": "$value",\n"""  
      }
      else if (!node.isRoot && value == null && attrs != null){
        output << """"$name": ["""
        attrs.each{key,values ->
        output << """"$values","""}
        output << "]" 
        output.deleteCharAt(output.lastIndexOf(','))
      }
      else{
        node.isContainer = true
        output << """"$name":{\n"""
      }
    }
    node.value = name
    return node
  }
  void setParent(parent,node){  
  }
  void nodeCompleted(parent, node){
    if (node.isContainer){
      output.deleteCharAt(output.lastIndexOf(','))
      output << "},\n"
    } 
    if (node.isRoot){
      output.deleteCharAt(output.lastIndexOf(','))
      output << "}"
    }
  }
}


def JSONbuilder = new JSONBuilder()
JSONbuilder{
  firstName 'Bashar'
  lastName 'Abdul Jawad'
  address {
    streetAddress '5151 E Broadway Blvd'
    city 'Tucson'
    state 'AZ'            
    company {
      name 'VMS'
      employees 1000   
      phoneNumbers(number1:"(520)202-3100",number2:"(520)202-3175")      
    }
  }
}
assert JSONbuilder.output.toString().trim() == """
{
"firstName": "Bashar",
"lastName": "Abdul Jawad",
"address":{
"streetAddress": "5151 E Broadway Blvd",
"city": "Tucson",
"state": "AZ",
"company":{
"name": "VMS",
"employees": "1000",
"phoneNumbers": ["(520)202-3100""(520)202-3175"]}
}
}""".trim()
