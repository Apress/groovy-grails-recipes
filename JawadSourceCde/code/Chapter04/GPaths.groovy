class BookSales{
  int numSold    
  Book book
  int sales(){
    return book.price * numSold
  }
}
class Book{
  int price
  float authorRoyaltyFee
  String title
}
class Author{
  String name
  List bookSales
  int totalEarnings(){
    def total = 0
    bookSales.each{
      total += it.sales() * it.book.authorRoyaltyFee
    }
  return total
  }
}
def book1 = new Book(title:"Groovy Grails Recipes", price:44, authorRoyaltyFee:0.1)
def book2 = new Book(title:"Groovy and Grails Rock", price:35, authorRoyaltyFee:0.2)
def bookSales1 = new BookSales(numSold : 5000, book: book1)
def bookSales2 = new BookSales(numSold : 1000, book: book2)
def authors = [
        new Author(name:"Bashar", bookSales: [bookSales1, bookSales2]),
        new Author(name:"Sami", bookSales:[bookSales2])]

assert authors*.totalEarnings() == [29000, 7000]
authors.bookSales.each{
    println it.grep{it.sales() > 200000}.book.title
}

