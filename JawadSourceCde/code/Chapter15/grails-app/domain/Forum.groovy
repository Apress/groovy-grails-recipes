class Forum {
  String name
  String description
  Date lastPost
  static hasMany = [topics: Topic]
}
