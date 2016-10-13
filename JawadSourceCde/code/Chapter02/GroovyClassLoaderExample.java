import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

import java.io.File;

public class GroovyClassLoaderExample{

  public static void main(String args[]) {
    try {
      GroovyClassLoader loader = new GroovyClassLoader();
      Class fileCreator = loader.parseClass
        (new File("GroovySimpleFileCreator.groovy"));
      GroovyObject object = (GroovyObject) fileCreator.newInstance();
      object.invokeMethod("createFile", "C:\\temp\\emptyFile.txt");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
