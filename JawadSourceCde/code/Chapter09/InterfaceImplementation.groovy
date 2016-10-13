//Groovy script that uses the template
import groovy.text.GStringTemplateEngine
def binding = ["interfaceToImplement":Comparator] //Implement Comparator interface
def f = new File('interface.template') //Path to your template
engine = new GStringTemplateEngine()
try{
template = engine.createTemplate(f).make(binding)
println template.toString()
}
catch(Exception e){
println "Can't find $f.absolutePath"
}
