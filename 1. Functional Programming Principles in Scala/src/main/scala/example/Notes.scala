package example

object Notes {
  // implementation for and(x,y) == x && y
  def and(x: Boolean, y: => Boolean) = if (x) y else false

  def and_2(x: Boolean, y: => Boolean) = if (!x) false else y

  // or(x,y) == x || y
  def or(x: Boolean, y: => Boolean) = if (x) true else y

  def or_2(x: Boolean, y: => Boolean) = if (!x) y else true

  // sqrt implementation
  def abs(x: Double) = if (x < 0) -x else x

  def sqrtIter(guess: Double, x: Double): Double =
    if (isGoodEnough(guess, x)) guess
    else sqrtIter(improve(guess, x), x)

  def isGoodEnough(guess: Double, x: Double): Boolean = abs(guess * guess - x) / x < 0.001

  def improve(guess: Double, x: Double) = (guess + x / guess) / 2

  def sqrt(x: Double) = sqrtIter(1.0, x)
}
