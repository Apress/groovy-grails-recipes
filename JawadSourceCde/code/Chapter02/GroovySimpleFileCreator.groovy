class GroovySimpleFileCreator {
  public createFile(String fileName){
    File file = new File(fileName);
    file.createNewFile();
  }
}
