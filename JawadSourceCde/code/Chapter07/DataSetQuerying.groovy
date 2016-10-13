import groovy.sql.Sql
import groovy.sql.DataSet

connection = Sql.newInstance(
  "jdbc:mysql://localhost:3306/company?allowMultiQueries=true",
   "root", "", "org.gjt.mm.mysql.Driver")
dataSet = new DataSet(connection,'employees')
dataSet.each{
    println it.firstName + " " + it.lastName
}
