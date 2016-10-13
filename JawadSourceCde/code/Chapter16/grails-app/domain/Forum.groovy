class Forum {
  String name
  String description
  static hasMany = [topics: Topic] 
}