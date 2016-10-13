def session = request.session
if (session.counter == null || params.reset) {
  session.counter = 0
}
if (params.increment)
  session.counter += 1
html.html {
  head {
    title 'Counter'
  }
  body {
    h1 'Groovlets Counter Example'
    div "The current value is $session.counter"
  }
  a(href: "counter.groovy?increment=true") {mkp.yield "increment"}
  br {}
  a(href: "counter.groovy?reset=true") {mkp.yield "reset"}
}
