class MOP{
 def methodMissing(String name, args) {
       "$name method doesn't exist, are you sure you spelled it right?"
    }
}
MOP mop = new MOP()
assert mop.none() == "none method doesn't exist, are you sure you spelled it right?"
