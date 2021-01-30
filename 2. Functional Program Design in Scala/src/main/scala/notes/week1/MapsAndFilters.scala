package notes.week1

object MapsAndFilters {
  def mapEx[T, U](xs: List[T], f: T => U): List[U] =
    for (x <- xs) yield f(x)

  def flatMapEx[T, U](xs: List[T], f: T => Iterable[U]): List[U] =
    for (x <- xs; y <- f(x)) yield y

  def filterEx[T](xs: List[T], p: T => Boolean): List[T] =
    for (x <- xs if p(x)) yield x
}
