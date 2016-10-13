import groovy.sql.Sql
connection = Sql.newInstance(
  "jdbc:mysql://localhost:3306/company?allowMultiQueries=true",
   "root", "", "org.gjt.mm.mysql.Driver")
String stmt = 'INSERT INTO employees (firstName, lastName) VALUES (?,?);'
connection.execute stmt, ['Bashar', 'Abdul'];
connection.execute stmt, ['Leslie', 'Valenzuela'];
connection.execute stmt, ['Scott', 'Segal'];
