def dirToScan = '/home/bjawad/Workspace/Old' //Directory to scan

def lastWeek = Calendar.getInstance()
lastWeek.add(Calendar.DATE, -7)
def archive = '/home/bjawad/Workspace/Old/archive' //Archive location
  if (!new File(archive).exists())
    new File(archive).mkdir()
    def numberOfLines = 0
    new File(dirToScan).eachFileRecurse { //Directory to scan
    f ->
    if (f.name.indexOf('.') != -1 && //Process .groovy files
        f.name.substring(f.name.indexOf('.'), f.name.length()) == '.groovy' ){
      if (f.lastModified() <= lastWeek.timeInMillis) {
        f.renameTo(new File(archive + File.separator + f.name))
      }                      
      else {   
        f.eachLine {
          numberOfLines++
        }                
      }
    }
  }
println "$numberOfLines lines were not archived"
