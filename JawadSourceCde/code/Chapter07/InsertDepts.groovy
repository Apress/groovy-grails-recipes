import groovy.sql.Sql
connection = Sql.newInstance(
  "jdbc:mysql://localhost:3306/company?allowMultiQueries=true", 
  "root", "", "org.gjt.mm.mysql.Driver")
String stmt = 'INSERT INTO depts (name) VALUES (?);'
connection.execute stmt, ['Accounting'];
connection.execute stmt, ['IT'];
