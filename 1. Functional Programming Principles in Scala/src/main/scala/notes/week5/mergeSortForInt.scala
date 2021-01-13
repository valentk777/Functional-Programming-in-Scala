package notes.week5

object mergeSortForInt {
  /**
   * merge sort
   * if list empty or contains only one element, then that list already sorted
   * if list contains 2+ elements, then split list into to (in half) and then sort them
   * after that merge two sorted list
   */
  def msort(xs: List[Int]): List[Int] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      // not that nice
      def merge(xs: List[Int], ys: List[Int]): List[Int] = xs match {
        case Nil => ys
        case x :: xs1 => ys match {
          case Nil => xs
          case y :: ys1 =>
            if (x < y) x :: merge(xs1, ys)
            else y :: merge(xs, ys1)
        }
      }

      // using pattern matching with pairs
      def merge2(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match {
        case (Nil, ys) => ys
        case (xs, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if (x < y) x :: merge2(xs1, ys)
          else y :: merge2(xs, ys1)
      }

      val (fst, snd) = xs splitAt n
      merge2(msort(fst), msort(snd))
    }
  }
}
