import groovy.lang.Binding;
import groovy.lang.GroovyShell;

public class GroovyShellExample {

  public static void main(String args[]) {
    Binding binding = new Binding();
    binding.setVariable("x", 10);
    binding.setVariable("language", "Groovy");
    GroovyShell shell = new GroovyShell(binding);
    Object value = shell.evaluate
      ("println \"Welcome to $language\"; y = x * 2; z = x * 3; return x ");
    assert value.equals(10);
    assert binding.getVariable("y").equals(20);
    assert binding.getVariable("z").equals(30);
  }
}
