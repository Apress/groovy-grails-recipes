import org.codehaus.groovy.grails.commons.GrailsApplication

def environment = System.getProperty(GrailsApplication.ENVIRONMENT)
if (environment == 'development'){
  dataSource.username = "sa"
  dataSource.password = ""
  dataSource.url = "jdbc:hsqldb:mem:devDB"
  dataSource.driverClassName = "org.hsqldb.jdbcDriver"
}

else if (environment == 'test'){
  dataSource.username = "sa"
  dataSource.password = ""
  dataSource.url = "jdbc:hsqldb:mem:testDb"
  dataSource.driverClassName = "org.hsqldb.jdbcDriver"
}

else { //Production
  dataSource.username = "root"
  dataSource.password = ""
  dataSource.url = "jdbc:mysql://localhost:3306/forum"
  dataSource.driverClassName = "org.gjt.mm.mysql.Driver"
}
