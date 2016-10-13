class Employee {
  String firstName = 'Bashar'
  String lastName
  private id
  def title
}
Employee employee = new Employee()
assert employee.properties.containsKey('firstName')
assert employee.properties.containsValue('Bashar')
assert employee.properties.containsKey('lastName')
assert employee.properties.containsKey('title')
assert employee.properties.containsKey('id') == false
