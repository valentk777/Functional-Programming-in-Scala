package notes.week5

object reduction {
  /**
   * reduceLeft - inserts a given binary operation between adjacent elements of a list
   *
   * example: sum(1, 6, 4, 8) => 1 + 6 + 4 + 8
   */

  def sum_reduceLeft(xs: List[Int]): Int = (0 :: xs) reduceLeft ((x, y) => x + y)

  def sum_reduceLeft_syntax(xs: List[Int]): Int = (0 :: xs) reduceLeft (_ + _)

  /** more generic:
   * foldLeft accept default value and operation */

  def sum_foldLeft(xs: List[Int]): Int = (xs foldLeft 0) (_ + _) // default value 0

  def concat[T](xs: List[T], ys: List[T]): List[T] =
    (xs foldRight ys) (_ :: _)

  //  def mapFun[T, U](xs: List[T], f: T => U): List[U] =
  //    (xs foldRight List[U]()) (???)
  //
  //  def lengthFun[T](xs: List[T]): Int =
  //    (xs foldRight 0) (???)
}
