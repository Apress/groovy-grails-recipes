class A {
  def count = 0
}

A a = new A()
a.count = 1
assert a.count == 1

a = new A()
a['count'] = 1
assert a['count'] == 1
