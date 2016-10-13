class ClosureScopeInAClass{
  def limit
  def closure = {limit * 2}
}

ClosureScopeInAClass example = new ClosureScopeInAClass(limit:10)
assert example.closure in Closure
assert example.closure() == 20
