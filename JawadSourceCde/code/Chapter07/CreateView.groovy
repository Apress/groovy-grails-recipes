import groovy.sql.Sql
connection = Sql.newInstance(
  "jdbc:mysql://localhost:3306/company?allowMultiQueries=true", 
  "root", "", "org.gjt.mm.mysql.Driver")
connection.execute '''
  DROP VIEW IF EXISTS DeptEmployees;
  CREATE VIEW DeptEmployees AS
  SELECT depts.deptID, depts.name, employees.firstName, employees.lastName,
     employees.id 'EmployeeId'  FROM depts INNER JOIN employees ON
     depts.deptId = employees.deptId
'''
