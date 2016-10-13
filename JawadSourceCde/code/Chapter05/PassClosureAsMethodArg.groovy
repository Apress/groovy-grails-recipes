public class ModifyList extends ArrayList {
  public ModifyList(def collection) {
    super(collection)
  }
  public void modify(closure) {
    for (i in 0..<this.size()) {
      this[i] = closure(this[i])
    }
  }
}
def list = new ModifyList([1, 2, 3])
list.modify({it * it})
assert list == [1, 4, 9]
list.modify({Math.sqrt(it)})
assert list == [1, 2, 3]
