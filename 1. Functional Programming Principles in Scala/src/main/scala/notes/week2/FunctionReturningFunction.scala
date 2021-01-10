package notes.week2

object FunctionReturningFunction {
  def sumIntInRange: (Int, Int) => Int = sum(x => x)

  def sumCubes: (Int, Int) => Int = sum(x => x * x * x)

  /**
   * functions returning functions
   */
  def sum(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int = {
      @scala.annotation.tailrec
      def loop(a: Int, acc: Int): Int = {
        if (a > b) acc
        else loop(a + 1, f(a) + acc)
      }

      loop(a, 0)
    }

    sumF
  }

  // examples
  sumIntInRange(5, 6) + sumCubes(4, 9)

  /**
   * functions returning functions
   * Syntactic sugar
   */
  def sumFF(f: Int => Int)(a: Int, b: Int): Int = {
    @scala.annotation.tailrec
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, f(a) + acc)
    }

    loop(a, 0)
  }

  def product(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 1
    else f(a) * product(f)(a + 1, b)
  }

  def fact(n: Int): Int = product(x => x)(1, n)

  fact(5)

  /**
   * mapReduce to expand product: product(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x * y, 1)(a, b)
   */
  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int = {
    if (a > b) zero
    else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
  }
}
