class Forum {
  String name
  String description
  Date lastPost
  SortedSet topics
  static hasMany = [topics: Topic]
  static mapping = {
    table 'forums' //Change the table's name
    name column: 'Forum_Name' //Change the "name" property column name
    lastPost type: 'timestamp' //Change the "lastPost" property column type
    cache usage:'read-only', include:'non-lazy'
    topics cache:false
    name index:'name_index'
  }
  static constraints = {
    description(nullable: true)
  }
  def getNameAndDescription() {
    return """
  name:$name
  description:$description
      """
  }
  static transients = ['nameAndDescription']

}
