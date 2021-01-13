package notes.week5


object maps {
  //  def map[U](f: T => U): List[U] = this match {
  //    case Nil => this
  //    case x :: xs => f(x) :: xs.map(f)
  //  }

  def squareList(xs: List[Int]): List[Int] = xs match {
    case Nil => List()
    case y :: ys => y * y :: squareList(ys)
  }

  def squareList2(xs: List[Int]): List[Int] = xs map (x => x * x)
}

