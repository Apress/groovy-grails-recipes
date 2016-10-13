class Topic {
  String subject
  String message
  def myFile
  static belongsTo = [forum: Forum]  
  static transients = ['myFile']
}