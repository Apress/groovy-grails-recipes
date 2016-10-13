import groovy.sql.Sql
connection = Sql.newInstance(
  "jdbc:mysql://localhost:3306/company?allowMultiQueries=true",
   "root", "bashar", "org.gjt.mm.mysql.Driver")
connection.execute '''
INSERT INTO employees (firstName, lastName)
    VALUES ('Bashar', 'Abdul');
INSERT INTO employees (firstName, lastName)
    VALUES ('Leslie', ' Valenzuela');
INSERT INTO employees (firstName, lastName)
    VALUES ('Scott', 'Segal');
'''
