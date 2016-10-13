def fibonacci(def n){
  if (n <=1 ) return n;
  return fibonacci(n - 1) + fibonacci(n - 2)
}

assert fibonacci(0) == 0, "fibonacci(0) is equal to 0"
assert fibonacci(1) == 1, "fibonacci(1) is equal to 1"
assert fibonacci(2) == 1
assert fibonacci(3) == 2
assert fibonacci(4) == 3
assert fibonacci(5) == 5
assert fibonacci(6) == 8
assert fibonacci(10) == 55
assert fibonacci(20) == 6765
