package notes.week2

object AndOr {
  // implementation for and(x,y) == x && y
  def and(x: Boolean, y: => Boolean): Boolean = if (x) y else false

  def and_2(x: Boolean, y: => Boolean): Boolean = if (!x) false else y

  // or(x,y) == x || y
  def or(x: Boolean, y: => Boolean): Boolean = if (x) true else y

  def or_2(x: Boolean, y: => Boolean): Boolean = if (!x) y else true

  // sqrt implementation
  def abs(x: Double): Double = if (x < 0) -x else x
}
