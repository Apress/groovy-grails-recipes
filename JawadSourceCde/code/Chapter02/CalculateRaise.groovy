public class Employee{
def salary
public double calculateRaise(c){
        return c(salary)
    }
}

Employee employee1 = new Employee(salary:1000)
def raise1 = {salary -> (salary * 1.5) }
assert employee1.calculateRaise(raise1) == 1500

Employee employee2 = new Employee(salary:500)
def raise2 = {salary -> (salary + 300) }
assert employee2.calculateRaise(raise2) == 800
