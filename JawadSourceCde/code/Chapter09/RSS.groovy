def url = 'http://rss.news.yahoo.com/rss/tech' //Yahoo tech feed
def channel =  new XmlParser().parse(url).channel[0]
println channel.title.text()
println channel.link.text()
println channel.description.text()
println '\nStories:\n---------'

def items = channel.item
for (item in items[0..2]){
  println item.title.text()
  println item.link.text()
  println item.description.text()
  println '--------'
}
