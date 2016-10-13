class Employee{
   String name
   int hourlyRate
   int numHoursWorkedPerWeek
   int numOfSalesPerYear    
}

def employeeTotal = {salaryCalculator, bonusesCalculator, employee ->
   salaryCalculator(employee) + bonusesCalculator(employee) 
}

def salaryCalculator = {employee -> employee.hourlyRate *
   employee.numHoursWorkedPerWeek * 52 }
def bonusesCalculator = {employee -> employee.numOfSalesPerYear * 100}
def employee = new Employee
  (name:"John", hourlyRate:50,numHoursWorkedPerWeek:40, numOfSalesPerYear : 50)
def calculateEmployeeTotal = employeeTotal.curry(salaryCalculator, bonusesCalculator)
assert calculateEmployeeTotal(employee) == 109000
