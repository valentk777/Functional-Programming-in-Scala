package notes.week5

object filters {
  //  def filter(p: T => Boolean): List[T] = this match {
  //    case Nil => this
  //    case x :: xs => if (p(x)) x :: xs.filter(p) else xs.filter(p)
  //  }

  def possitiveElements(xs: List[Int]): List[Int] =
    xs filter (x => x > 0)
}
