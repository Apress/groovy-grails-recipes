import groovy.sql.Sql
import java.sql.ResultSetMetaData

connection = Sql.newInstance(
  "jdbc:mysql://localhost:3306/company?allowMultiQueries=true", "root",
   "", "org.gjt.mm.mysql.Driver")
connection.query('SELECT * from employees'){ resultSet ->
  ResultSetMetaData metaData = resultSet.metaData
  println "Table name is " + metaData.getTableName(1)
  for (i in 0..<metaData.columnCount){
    println "${i + 1}- " + metaData.getColumnLabel(i + 1) + ": " + metaData.getColumnTypeName(i + 1)
  }
}
