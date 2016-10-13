class DisemvowelingCodec{
  static encode = {str ->
    str.replaceAll('(?i)a|e|i|o|u','')
  }
}