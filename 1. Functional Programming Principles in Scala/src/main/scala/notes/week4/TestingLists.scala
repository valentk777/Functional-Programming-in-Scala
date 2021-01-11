package notes.week4

object TestingLists extends App {
  val fruit: List[String] = List("aaa", "cccc")
  val nums: List[Int] = List(1, 5, 6)
  val diag3: List[List[Int]] = List(List(1, 5, 6), List(1, 5, 6), List(1, 5, 6))
  val empty: List[Nothing] = List()

  // empty list in scala is Nil
  val empty2: List[Nothing] = Nil

  // we can define list as join of elements
  // where :: (pronounced cons); x :: xs gives a new list with the first element x, followed by the elements of xs

  val fruits = "dddd" :: ("rrrr" :: Nil)

  // or without parentheses
  //  val fruits = "dddd" :: "rrrr" :: Nil

  // all list element have three operations: head, tail, isEmpty

  // list in patterns matching

  def matchingP(l: List[Any]): Int = l match {
    case 1 :: 2 :: xs => 1 // List of that start with 1, and then 2
    case x :: Nil => 2 // List of length 1. Same as List(x)
    case List() => 3 // List of length 0 (empty list). Same as Nil
    case List(2 :: _) => 4 // a List that contains as only element another list that starts with 2
  }

  // insertion sort
  def isort(xs: List[Int]): List[Int] = xs match {
    case List() => List()
    case y :: ys => insert(y, isort(ys))
  }

  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case List() => List(x)
    case y :: ys => if (x <= y) x :: xs else y :: insert(x, ys)
  }

}
