def total = 0
5.downto(0) {
  total += it
}
assert total == 15

0.upto(5){
  total -= it
}
assert total == 0
