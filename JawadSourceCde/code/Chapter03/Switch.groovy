x = 'Groovy'
def result = ''
switch (x){
    case ['1','2','3']: result = 'List'
    case Integer: result = 'Integer'
    case 'Groovy': result = 'String' //Fall through
    case 'G'..'Y': result = 'Range'
    case ~/G.*/: result = 'Pattern'; break
    default: result = 'Default'
}

assert result == 'Pattern'