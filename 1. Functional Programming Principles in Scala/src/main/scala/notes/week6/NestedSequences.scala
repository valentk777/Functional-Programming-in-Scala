package notes.week6

object NestedSequences {
  val persons = List(Person("xxxx", 50))

  /**
   * Given a positive integer n, find all pairs of positive integers i and j, with 1 <= j < i < n, such that i + j is prime
   *
   * if n = 7L
   * i     | 2 3 4 4 5 6 6
   * j     | 1 2 1 3 2 1 5
   * -------------------------
   * i + j | 3 5 5 7 7 7 11
   */

  def answer(n: Int): IndexedSeq[(Int, Int)] =
    (1 until n) flatMap (i =>
      (1 until i) map (j => (i, j))) filter (pair =>
      Examples.isPrime(pair._1 + pair._2))

  // using for generator, we can rewrite our answer
  def answer_for(n: Int): IndexedSeq[(Int, Int)] =
    for {
      i <- 1 until n
      j <- 1 until i
      if Examples.isPrime(i + j)
    } yield (i, j)

  for (p <- persons if p.age > 20) yield p.name // same as persons filter (p => p.age > 20) map (p => p.name)

  def scalarProduction(xs: Vector[Double], ys: Vector[Double]): Double =
    (for {
      x <- xs
      y <- ys
    }
      yield x * y).sum

  case class Person(name: String, age: Int)

}
