package notes.week3

object Main extends App {
  val t1 = new NonEmpty(3, new Empty, new Empty)
  val t2 = t1 incl 4
  val t3 = new NonEmpty(5, new NonEmpty(2, new Empty, new Empty), new NonEmpty(9, new Empty, new Empty))

  println(t1)
  println(t2)
  println(t1 union t3)

//  val listTest = new Cons(1, Cons(2, Cons(3, new Nil)))
}
