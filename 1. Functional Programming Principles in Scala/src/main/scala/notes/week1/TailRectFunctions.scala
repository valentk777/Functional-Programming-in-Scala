package notes.week1

import scala.math.abs

object TailRectFunctions {

  def isGoodEnough(guess: Double, x: Double): Boolean = abs(guess * guess - x) / x < 0.001

  @scala.annotation.tailrec
  def sqrtIter(guess: Double, x: Double): Double =
    if (isGoodEnough(guess, x)) guess
    else sqrtIter(improve(guess, x), x)

  def improve(guess: Double, x: Double): Double = (guess + x / guess) / 2

  def sqrt(x: Double): Double = sqrtIter(1.0, x)

  /**
   * tail recursion
   * if a function calls itself as its last action
   * a tail recursive function can execute in constant stuck space
   * this avoid deep recursive
   */
  @scala.annotation.tailrec
  def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  /**
   * not a tail recursion version of factorial 5 * (4 * (3 * (2 * (1 * 1))))
   */
  def factorial(n: Int): Int = if (n == 0) 1 else n * factorial(n - 1)

  /**
   * a tail recursion version of factorial
   */
  def factorial2(n: Int): Int = {
    @scala.annotation.tailrec
    def loop(acc: Int, n: Int): Int = {
      if (n == 0) acc
      else loop(acc * n, n - 1)
    }

    loop(1, n)
  }

  /**
   * tail recursion version of sum
   */
  def sum(f: Int => Int, a: Int, b: Int): Int = {
    @scala.annotation.tailrec
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, f(a) + acc)
    }

    loop(a, 0)
  }
}
