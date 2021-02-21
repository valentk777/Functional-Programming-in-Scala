package notes.week1

case class Book(title: String, authors: List[String])

object queries {
  val books: List[Book] = List(
    Book(title = "title 1", authors = List("a1", "a3")),
    Book(title = "title 2 1", authors = List("a5", "a3")),
    Book(title = "title 3", authors = List("a3")),
    Book(title = "title 4 77", authors = List("a1", "a3", "a5")),
    Book(title = "title 5", authors = List("a1")),
  )

  // find a title of books whose author's name is a1
  for (b <- books; a <- b.authors if a startsWith "a1")
    yield b.title

  //  books flatMap (b =>
  //    b.authors withFilter(a => a startsWith "a1") map (y => y.title)
  //  )


  // find all the books which have the word 1 in the title
  for (c <- books if c.title.indexOf("1") >= 0)
    yield c.title

  // to find the names of all authors who have written at least two books present in the database
  {
    for {
      b1 <- books
      b2 <- books
      if b1 != b2
      a1 <- b1.authors
      a2 <- b2.authors
      if a1 == a2
    }
      yield a1
  }.distinct // to remove duplicates when same author has written two books
}
