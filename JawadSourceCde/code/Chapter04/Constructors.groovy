class Employee{
  String firstName,lastName
  Employee(firstName, lastName){
    this.firstName = firstName
    this.lastName = lastName
  }
}

   def employee = new Employee('Bashar','AbdulJawad')
   employee = ['Bashar','Abdul Jawad'] as Employee
   Employee employee2 = ['Bashar','AbdulJawad']
   Employee employee3
   employee3  = ['Bashar','Abdul']
