import java.util.logging.*
class EvenOddTest extends GroovyLogTestCase {
  private evenOdd
  private numbers
  void setUp(){
    evenOdd = new EvenOdd()
    numbers = [2,3,4,5,6,7,8]
  }
  void testEvenOddLog(){
    def log = stringLog(Level.FINER, 'EvenOdd'){
      numbers.each{evenOdd.isEven(it)}
    }
    println log
  }
}
