import groovy.sql.Sql

connection = Sql.newInstance("jdbc:mysql://localhost:3306/company", "root",
           "", "org.gjt.mm.mysql.Driver")
