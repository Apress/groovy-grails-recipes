class Employee{
  String firstName, lastName
  def id
  String dept
  String getName(){
    return firstName + ' ' + lastName
  }
}
Employee employee = new Employee()
employee.firstName = 'Bashar'
employee.lastName = 'Abdul'
assert employee.getFirstName() == 'Bashar'
assert employee.lastName == 'Abdul'
assert employee.name == 'Bashar Abdul'
