def writer = new FileWriter('C:\\temp\\test.html')
def html = new groovy.xml.MarkupBuilder(writer)
html.html{
  head{
    title 'MarkupBuilder example'
  }
  body{
    h1 'Generated by MarkupBuilder'
    form (name:'input', action:'', method:'get'){
      'span' 'Male:'
      input (type:'radio', name:'Sex', value:'Male', checked:'checked')
      br()
      'span' 'Female:'
      input (type:'radio', name:'Sex', value:'Female')
      br('')
      input (type:'submit', value:'Submit')
    }
  }
}