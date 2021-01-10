package notes.week3.week2

object SumsIntInRange {
  /**
   * Take a sum of integers between a and b
   */
  def sumIntInRange(a: Int, b: Int): Int = if (a > b) 0 else a + sumIntInRange(a + 1, b)

  def sumCubes(a: Int, b: Int): Int = {
    def cube(x: Int): Int = x * x * x

    if (a > b) 0 else cube(a) + sumCubes(a + 1, b)
  }

  def sumFactorials(a: Int, b: Int): Int = {
    @scala.annotation.tailrec
    def fact(x: Int): Int = if (x == 0) 1 else fact(x - 1)

    if (a > b) 0 else fact(a) + sumFactorials(a + 1, b)
  }
}
