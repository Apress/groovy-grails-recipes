import groovy.sql.Sql
connection = Sql.newInstance("jdbc:mysql://localhost:3306/company?allowMultiQueries=true", "root",
 "", "org.gjt.mm.mysql.Driver")

connection.execute '''
DROP TABLE IF EXISTS employees;
CREATE TABLE employees(
  id   BIGINT(20) NOT NULL AUTO_INCREMENT,
  firstName  VARCHAR(64),
  lastName  VARCHAR(64),
  PRIMARY KEY  (`id`)
  );
'''
