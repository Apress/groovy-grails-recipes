class RomanNumber { 
    private String number
    
    static numbers = ["I","II","III","IV","V","VI","VII","VIII","IX","X"]
    
    RomanNumber(number){
      this.number = number
    }
    
    boolean equals (Object other){
      if (null == other)  return false
      if (! (other instanceof RomanNumber)) return false
      if (number != other.number) return false
      return true
    }
    
    int hashCode(){
      number.hashCode()
    }
    
    String toString(){
      this.number
    }
    
    RomanNumber next(){
      if (this.number.toUpperCase() == "X")
         throw new UnsupportedOperationException
           ("Sorry, you can only increment Roman Numbers up to X")
      int index = numbers.indexOf(this.number.toUpperCase())
      if (index < 0)
        throw new IllegalArgumentException("Unknown Roman Number " + this.number)
      
      return new RomanNumber(numbers[index + 1])
    }
  }

def number = new RomanNumber("II");
println  "Number: $number"
number++;
assert number == new RomanNumber("III")
println  "After incrementing: $number"
number++;
assert number == new RomanNumber("IV")
println  "After incrementing: $number"
