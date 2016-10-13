import groovy.text.SimpleTemplateEngine
def text = '''
From: $fromEmail
To: $toEmail
Dear $name,
Please click on the following URL to activate your account:
${link}
Thanks,
$signature
<%= new java.text.SimpleDateFormat("MM\\\\dd\\\\yyyy").format(new Date()) %>
'''

def binding = ["fromEmail":"registration@groovy.codehaus.org",
 "toEmail":"john@smith.com", "name":"John Smith",
"link":"http://groovy.codehaus.org/activate", "signature":"Registration"]
def engine = new SimpleTemplateEngine()
template = engine.createTemplate(text).make(binding)
println template.toString()
