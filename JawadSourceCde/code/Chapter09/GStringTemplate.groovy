import groovy.text.GStringTemplateEngine
def binding = ["fromEmail":"registration@groovy.codehaus.org",
  "toEmail":"john@smith.com", 
  "name":"John Smith", 
  "link":"http://groovy.codehaus.org/activate",
  "signature":"Registration"]

//Path to your template file
def f = new File('registration.template')
engine = new GStringTemplateEngine()
try {
template = engine.createTemplate(f).make(binding)
println template.toString()
}
catch (Exception e){
 println "Can't find $f.absolutePath"
}

