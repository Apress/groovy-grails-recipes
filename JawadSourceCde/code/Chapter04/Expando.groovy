def author = new Expando()
assert author.books == null
author.books = ['Book 1']
assert author.books == ['Book 1']
author.writeBook = { -> return author.books += 'Book ' + (author.books.size() + 1) }
author.writeBook()
assert author.books == ['Book 1','Book 2']
author.writeBook()
assert author.books == ['Book 1','Book 2', 'Book 3']
