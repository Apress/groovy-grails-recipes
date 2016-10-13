class StringExtended {
  static String getFirstHalf(String string) {
    return string.substring(0, (int)(string.size() /2))
  }
}
use (StringExtended){
  assert "Return the first half of this string"
  .getFirstHalf() == "Return the first h"
}
