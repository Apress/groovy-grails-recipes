//FileCreator.java:

import java.io.File;
import java.io.IOException;

public class FileCreator {
  public static void main (String args[]){
    File file = new File("C:\\temp\\groovy.txt");
    try {
      file.createNewFile();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

