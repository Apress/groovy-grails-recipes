class ForumTagLib {
  static namespace = "custom"
  def convertTemperature = { attrs,body ->
    def result
    def originalTemp = Integer.parseInt(attrs.temperature)
    if (attrs.from == 'f') {
      result = (originalTemp - 32) * 5/9
    }
    else{
      result = (9/5 * originalTemp) + 32
    }
    out << result
  }
}
