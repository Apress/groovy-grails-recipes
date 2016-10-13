class Outputter {
  def saySomething
  public Outputter(def saySomething){
    this.saySomething = saySomething
  }
  public String output() {
    return saySomething.something()
  }
}

new Outputter([something:{println "Hello World"}]).output()
