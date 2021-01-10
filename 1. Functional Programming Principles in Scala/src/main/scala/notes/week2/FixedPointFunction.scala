package notes.week2

import scala.math.abs

object FixedPointFunction {
  /**
   * Fixed point of a function
   * The number x is called fixed point of a function f if f(x) = x
   * for some functions f, we can locate the fixed points by starting with an initial estimate and then by applying f
   * in a repetitive way: x, f(x), f(f(x)), f(f(f(x))),...
   */
  val tolerance = 0.001

  def sqrt(x: Double): Double = fixedPoint(averageDamp(y => x / y))(1)

  def fixedPoint(f: Double => Double)(firstGuess: Double): Double = {
    @scala.annotation.tailrec
    def iterate(guess: Double): Double = {
      println("guess = " + guess)
      val next = f(guess)
      if (isCloseEnough(guess, next)) next
      else iterate(next)
    }

    iterate(firstGuess)
  }

  //  fixedPoint(x => 1 + x / 2)

  //    def sqrt(x: Double): Double = fixedPoint(y => (y + x) / y)(1)

  def isCloseEnough(x: Double, y: Double): Boolean = abs((x - y) / x) / x < tolerance

  def averageDamp(f: Double => Double)(x: Double): Double = (x + f(x)) / 2
}
