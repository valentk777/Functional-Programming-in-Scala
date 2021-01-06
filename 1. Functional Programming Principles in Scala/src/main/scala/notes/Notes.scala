package notes

object Notes {
  /**
   * now we want to have one sum function for all possible functional cases
   * where f(x) any function applied for number
   */
  def sum(f: Int => Int, a: Int, b: Int): Int = {
    if (a > b) 0
    else f(a) + sum(f, a + 1, b)
  }

  def sumIntInRange(a: Int, b: Int): Int = sum(id, a, b)

  def sumCubes(a: Int, b: Int): Int = sum(cube, a, b)

  def sumFactorials(a: Int, b: Int): Int = sum(fact, a, b)

  def id(x: Int): Int = x

  def cube(x: Int): Int = x * x * x

  @scala.annotation.tailrec
  def fact(x: Int): Int = if (x == 0) 1 else fact(x - 1)
}
