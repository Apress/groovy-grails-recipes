import java.util.regex.Matcher
def matcher = "Groovy" =~ /G.*/
assert matcher in Matcher
assert matcher.matches()
