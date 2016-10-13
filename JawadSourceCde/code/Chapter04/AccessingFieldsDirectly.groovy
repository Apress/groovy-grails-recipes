class Employee {
  private String name
  def setName(name){
    this.name = name
  }
  def getName(){
    return name.toUpperCase()
  }
}
def employee = new Employee(name: 'Bashar')
assert employee.name == 'BASHAR'
assert employee.@name == 'Bashar'
