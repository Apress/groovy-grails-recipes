import groovy.sql.Sql
connection = Sql.newInstance(
  "jdbc:mysql://localhost:3306/company?allowMultiQueries=true",
   "root", "", "org.gjt.mm.mysql.Driver")
connection.query('SELECT * from employees'){ resultSet ->
        while (resultSet.next()){
            println resultSet.getString('firstName') + " " + resultSet.getString('lastName')
        }
}
