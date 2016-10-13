interface SaySomething
{ String something() ; }

class Outputter {
  SaySomething saySomething
  public Outputter(SaySomething saySomething){
    this.saySomething = saySomething
  }
  public String output() {
    return saySomething.something()
  }
}

new Outputter({println "Hello World"} as SaySomething).output()
