class Topic {
  String subject
  String message
  Date date
  static belongsTo = [forum: Forum]
  static hasMany = [posts: Post]    
  static constraints = {
      date(nullable:true)
  }
}