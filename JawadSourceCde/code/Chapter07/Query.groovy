import groovy.sql.Sql
connection = Sql.newInstance(
  "jdbc:mysql://localhost:3306/company?allowMultiQueries=true",
   "root", "bashar", "org.gjt.mm.mysql.Driver")
connection.rows("select firstName, lastName from employees").each{
    println it.firstName + " " + it.lastName
}
