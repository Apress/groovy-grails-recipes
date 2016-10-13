def odd = {
  switch(it){
    case {it % 2 == 1} : return true; break
    default: return false
  }
}
assert odd(3) == true
assert odd(4) == false 
