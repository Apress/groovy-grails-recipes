public class Thing {
  public boolean equals(Object o) {
    if (o == null) return false;
    if (!(o instanceof Thing)) return false;
    Thing thing = (Thing) o;
    return true; //custom logic here
  }
}