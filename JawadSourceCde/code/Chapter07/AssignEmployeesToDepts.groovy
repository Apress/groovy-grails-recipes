import groovy.sql.Sql
connection = Sql.newInstance(
  "jdbc:mysql://localhost:3306/company?allowMultiQueries=true",
   "root", "", "org.gjt.mm.mysql.Driver")
def assignToDept(firstName, lastName, deptName)
{
  connection.execute """
  UPDATE employees SET deptId = (SELECT deptId from depts WHERE name = $deptName)
   WHERE firstName = $firstName AND lastName = $lastName;
  """
}

assignToDept('Leslie','Valenzuela', 'Accounting')
assignToDept('Scott','Segal', 'IT')
assignToDept('Bashar','Abdul', 'IT')
