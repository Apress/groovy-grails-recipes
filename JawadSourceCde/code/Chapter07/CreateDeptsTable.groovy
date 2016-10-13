import groovy.sql.Sql
connection = Sql.newInstance(
  "jdbc:mysql://localhost:3306/company?allowMultiQueries=true",
   "root", "", "org.gjt.mm.mysql.Driver")
connection.execute '''
DROP TABLE IF EXISTS depts;
CREATE TABLE depts(
  deptId   BIGINT(20) NOT NULL AUTO_INCREMENT,
  name  VARCHAR(64),
  PRIMARY KEY  (`deptId`)
  );
'''
