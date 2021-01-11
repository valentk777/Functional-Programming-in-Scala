package notes.week4

import notes.week3.Polymorphism.{Cons, List, Nil}

object MyList {
  // List()
  // List(1)  => List.apply(1)
  // List(1, 5, ...., 8)

  def apply[T](): List[T] = new Nil

  def apply[T](x1: T, x2: T): List[T] = new Cons(x1, new Cons(x2, new Nil))
}
