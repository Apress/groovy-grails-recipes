def language = "Groovy"
def text = """
Welcome to $language
------------------
"""

assert text == "\nWelcome to Groovy\n------------------\n"
