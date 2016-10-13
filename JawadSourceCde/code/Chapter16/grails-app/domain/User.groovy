class User {
  String name
  String password
  Integer numberOfLogins

  static constraints = {
    numberOfLogins(nullable: true)
  }
}
