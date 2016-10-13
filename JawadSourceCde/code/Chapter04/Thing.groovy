class Thing{
  boolean equals(Thing thing){
    return true //custom logic here
  }
}

Object thing = new Thing()
Object object = new Object()
assert new Thing().equals(thing)
assert ! new Thing().equals(object)
