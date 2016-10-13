class Company{
  List depts = []
}
class Dept{
  def name
  List employees = []
}
class Employee{
  def name
}
def builder = new ObjectGraphBuilder(classLoader: getClass().classLoader)
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

company.depts.each{
  println it.name
}
dept = company.depts.grep{it.employees.any{it.name == 'Leslie'}}.name
assert dept == ['Accounting']
