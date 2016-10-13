class Forum {
  String name
  String description
  static hasMany = [topics: Topic]
  static constraints = {
    name(blank: false,unique:true,size:4..30)
    description(blank: false,maxSize: 1000,minSize:20)
  }
  String toString() {
    return name
  }
}