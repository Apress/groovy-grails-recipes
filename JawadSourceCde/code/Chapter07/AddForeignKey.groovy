import groovy.sql.Sql
connection = Sql.newInstance(
  "jdbc:mysql://localhost:3306/company?allowMultiQueries=true",
   "root", "", "org.gjt.mm.mysql.Driver")
connection.execute '''
ALTER TABLE employees
ADD deptId BIGINT(20),
ADD FOREIGN KEY (deptId)  REFERENCES depts(deptId)
'''
