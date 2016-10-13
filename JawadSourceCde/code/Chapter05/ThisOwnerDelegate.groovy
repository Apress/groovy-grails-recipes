class SpecialMeanings{
  def closure = {
    println this.class.name //Prints the class name
    assert owner.class.name != delegate.class.name
    println owner.class.name //Prints the class name
    println delegate.class.name //Prints the script name
    def nested = {
      println this.class.name //Prints the class name
      assert owner.class.name == delegate.class.name
      println owner.class.name //Prints the outer closure name
    }
    nested()  
  }
}

def closure = new SpecialMeanings().closure
closure.delegate = this
closure()
