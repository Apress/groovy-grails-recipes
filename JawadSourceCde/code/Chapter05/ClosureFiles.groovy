directory = new File("C:\\temp\\")
directory.eachDir{println it} //Prints each directory under the given location
directory.eachDirRecurse{println it} //Prints each directory recursivley
//Prints each directory that matches the given filter
directory.eachDirMatch("test"){println it} 
file = new File(directory.absolutePath + File.separator + "test.txt")
file.eachLine{println it} //Prints each line in the file
