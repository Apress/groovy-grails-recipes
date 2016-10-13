def url = new URL("http://groovy.codehaus.org")
def a = url.openConnection()
println a.getContentType()
