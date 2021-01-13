package notes.week5

import scala.math.Ordering

object mergeSortImplicit {
  /**
   * merge sort
   * if list empty or contains only one element, then that list already sorted
   * if list contains 2+ elements, then split list into to (in half) and then sort them
   * after that merge two sorted list
   */
  def msort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      // using pattern matching with pairs
      def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
        case (Nil, ys) => ys
        case (xs, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if (ord.lt(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }

      val (fst, snd) = xs splitAt n
      merge(msort(fst), msort(snd))
    }
  }
}
