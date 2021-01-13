package notes.week5

object packs {
  //  // List(List("a", "a", "a"), List("b"), List("c", "c"), List("a"))
  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case x :: _ => {
      val (left: List[T], right: List[T]) = xs.span(y => y == x)
      left :: pack(right)
    }
  }
}
