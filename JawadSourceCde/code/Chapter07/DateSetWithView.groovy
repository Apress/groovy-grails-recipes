import groovy.sql.Sql
import groovy.sql.DataSet

connection = Sql.newInstance(
  "jdbc:mysql://localhost:3306/company?allowMultiQueries=true",
   "root", "", "org.gjt.mm.mysql.Driver")
dataSet = connection.dataSet('DeptEmployees')
dataSet.each{
  if(it.name == 'IT')
    println "$it"
}
