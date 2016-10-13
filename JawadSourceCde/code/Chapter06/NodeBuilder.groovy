def builder = new NodeBuilder()
def company = builder.company{
  dept(name:'IT'){
    employee(name:'Alan')
    employee(name:'Steve')        
  }
  dept(name:'Accounting'){
    employee(name:'Leslie')
    employee(name:'Rene')
  }   
}

company.dept.each{
    println it.'@name'
}
dept = company.grep{it.employee.any{it.'@name' == 'Leslie'}}.'@name'
assert dept == ['Accounting']

def writer = new StringWriter()
company.print(new PrintWriter(writer))
println writer.toString()
