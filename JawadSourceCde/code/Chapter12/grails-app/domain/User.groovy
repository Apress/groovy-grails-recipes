class User {
  String firstName
  String lastName
  String email
  static hasMany = [topics: Topic, posts: Post]
  static belongsTo = [forum: Forum]
  Avatar avatar
  static constraints = {avatar(unique: true)}
  static embedded = ['address']
}

class Address {
  String address1
  String address2
  int zip
  int phone
}
  
