package com.apress.groovygrailsrecipes.chap01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SampleFileReader {
  static public String readFile(File file) {
    StringBuffer contents = new StringBuffer();
    try {
      BufferedReader reader = new BufferedReader(new FileReader(file));
      try {
        String line = null;
        while ((line = reader.readLine()) != null) {
          contents.append(line).append
          (System.getProperty("line.separator"));
        }
      } finally {
        reader.close();
      }
    } catch (IOException ex) {
      contents.append(ex.getMessage());
      ex.printStackTrace();
    }
    return contents.toString();
  }

  public static void main(String[] args) {
    File file = new File("test.txt");
    System.out.println(SampleFileReader.readFile(file));
  }
}
