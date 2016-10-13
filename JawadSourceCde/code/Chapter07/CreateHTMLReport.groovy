import groovy.sql.Sql
connection = Sql.newInstance(
  "jdbc:mysql://localhost:3306/company?allowMultiQueries=true",
   "root", "", "org.gjt.mm.mysql.Driver")
def writer = new FileWriter('C:\\temp\\employees.html')
def html = new groovy.xml.MarkupBuilder(writer)
html.html
{
  head{
    title 'Employees Table'
  }
  body
  {
    h1 'Employees'
    table(border:1){ 
      th('first name')
      th('last name')
      connection.eachRow('select firstName, lastName from employees')
      {
      employee ->
        tr{
          td(employee.firstName)
          td(employee.lastName)  
        }
      }
    }
  }
}
