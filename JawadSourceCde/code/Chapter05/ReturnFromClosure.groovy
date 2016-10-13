def divide = {number1,number2->
  if (number2 == 0) return "Undefined"
  return number1 / number2
}
assert divide(4,2) == 2
assert divide(4,0) == "Undefined"
