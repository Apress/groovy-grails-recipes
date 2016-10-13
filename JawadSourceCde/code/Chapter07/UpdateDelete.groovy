import groovy.sql.Sql
connection = Sql.newInstance(
  "jdbc:mysql://localhost:3306/company?allowMultiQueries=true",
   "root", "", "org.gjt.mm.mysql.Driver")
connection.execute """
 UPDATE employees SET lastName = 'Seagull' WHERE lastName = 'Segal';
 DELETE from employees WHERE lastName = 'Seagull';
"""
