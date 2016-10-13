import com.mysql.jdbc.jdbc2.optional.*

def dataSource = new MysqlConnectionPoolDataSource()
dataSource.URL = 'jdbc:mysql://localhost:3306/company'
dataSource.user = 'root'
dataSource.password = ''

connection = new groovy.sql.Sql(dataSource)
