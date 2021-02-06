import forcomp.Anagrams.Occurrences


def subtract(x: Occurrences, y: Occurrences): Occurrences = {
  val (ys, xs) = x.partition(a => y.exists(b => a._1 == b._1))
  // ys == y
  val diffed = for ((a, b) <- ys.zip(y) if a._2 != b._2) yield (a._1, a._2 - b._2)
  (xs ++ diffed).sorted
}


val lard = List(('a', 1), ('d', 1), ('l', 1), ('r', 2))
val r = List(('r', 1))
val lad = List(('a', 1), ('d', 1), ('l', 1), ('r', 1))

subtract(lard, r)
