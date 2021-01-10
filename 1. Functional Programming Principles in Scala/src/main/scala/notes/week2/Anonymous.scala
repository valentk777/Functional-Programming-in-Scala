package notes.week2

object Anonymous {
  /**
   * Anonymous Functions (functions without name)
   * Syntactic sugar
   */
  def sum(f: Int => Int, a: Int, b: Int): Int = {
    if (a > b) 0
    else f(a) + sum(f, a + 1, b)
  }

  def sumIntInRange(a: Int, b: Int): Int = sum(x => x, a, b)

  def sumCubes(a: Int, b: Int): Int = sum(x => x * x * x, a, b)
}
