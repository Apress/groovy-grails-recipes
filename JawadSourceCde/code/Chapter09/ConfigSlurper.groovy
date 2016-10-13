def config = new ConfigSlurper().parse(new File('Config.groovy').toURL())
assert config.log4j.appender.stdout == "org.apache.log4j.ConsoleAppender"
assert config.log4j.appender.'stdout.layout' == "org.apache.log4j.PatternLayout"
def props = config.toProperties()
assert props instanceof java.util.Properties
new File("configuration.groovy").withWriter { writer ->
     config.writeTo(writer)
}
