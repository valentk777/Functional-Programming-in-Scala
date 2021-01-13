package notes.week6

object Sets {
  // no duplicate
  // no order
  // contains
  val fruit = Set(1, 5, 6)
  fruit.head

  // place n chess queens on chess board that it not intersect

  def queens(n: Int): Set[List[Int]] = {
    def placeQueens(k: Int): Set[List[Int]] =
      if (k == 0) Set(List())
      else
        for {
          queens <- placeQueens(k - 1)
          col <- 0 until n
          if isSafe(col, queens)
        } yield col :: queens

    def isSafe(col: Int, queens: List[Int]): Boolean = {
      val row = queens.length
      val queensWithRow = (row - 1 to 0 by -1) zip queens
      queensWithRow forall {
        case (r, c) => col != c && math.abs(col - c) != row - r
      }
    }

    placeQueens(n)
  }

  def show(queens: List[Int]): String = {
    val lines = for (col <- queens.reverse)
      yield Vector.fill(queens.length)("* | ").updated(col, "X | ").mkString
    "\n" + (lines mkString "\n")
  }
}
