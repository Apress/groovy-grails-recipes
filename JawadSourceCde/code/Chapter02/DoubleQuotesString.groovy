def language = "Groovy"
def text = "Welcome to $language"
assert text == "Welcome to Groovy"
assert text as groovy.lang.GString
