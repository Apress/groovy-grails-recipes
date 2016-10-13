import groovy.sql.Sql
import groovy.sql.DataSet

public class DataSetFilter{
  static main(args){
    def connection = Sql.newInstance(
      "jdbc:mysql://localhost:3306/company?allowMultiQueries=true",
      "root", "", "org.gjt.mm.mysql.Driver")
    def dataSet = new DataSet(connection,'employees')
    def results = dataSet.findAll({it.firstName ==  'Leslie'})
    println results.sql
    results.each{println it.firstName}
  }
}
