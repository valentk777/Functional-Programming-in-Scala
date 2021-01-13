package notes.week5

object encode {
  // List(("a", 3), ("b", 1), ("c", 2), ("a", 1))
  def encode[T](xs: List[T]): List[(T, Int)] = {
    val p = packs.pack(xs)

    def iter(current: List[T], remaining: List[List[T]]): List[(T, Int)] = {
      if (remaining.isEmpty) List((current.head, current.length))
      else List((current.head, current.length)) ::: iter(remaining.head, remaining.tail)
    }

    if (p.isEmpty) Nil
    else iter(p.head, p.tail)
  }

  // List(("a", 3), ("b", 1), ("c", 2), ("a", 1))
  def encode2[T](xs: List[T]): List[(T, Int)] =
    packs.pack(xs) map (ys => (ys.head, ys.length))
}
