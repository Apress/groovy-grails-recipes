class Topic {
  String subject
  String message
  Date date
  int rating
  static belongsTo = [forum: Forum]
  static constraints = {
    subject(blank: false)
    message(blank: false, maxSize: 1000, validator: {
      val, obj -> return val != obj.subject})
  }
  String toString() {
    return message
  }
}