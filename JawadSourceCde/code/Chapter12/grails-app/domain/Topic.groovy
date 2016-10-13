class Topic extends Post implements Comparable {
    String subject
    static hasMany = [forums: Forum, posts: Post]
    static belongsTo = Forum

    int compareTo(obj) {
        date.compareTo(obj.date)
    }

    static constraints = {
        date(nullable: true)
    }
      static mapping = {
    id composite:['date', 'forum']
  }

}
