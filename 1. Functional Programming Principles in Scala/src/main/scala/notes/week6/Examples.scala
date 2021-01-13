package notes.week6

object Examples {
  /**
   * sum of two list every element multiplication
   */
  def scalarProduction(xs: Vector[Double], ys: Vector[Double]): Double =
    (xs zip ys).map(xy => xy._1 * xy._2).sum

  // pattern matching
  def scalarProduction2(xs: Vector[Double], ys: Vector[Double]): Double =
    (xs zip ys).map { case (x, y) => x * y }.sum

  def isPrime(n: Int): Boolean = (2 until n) forall (d => n % d != 0)
}
