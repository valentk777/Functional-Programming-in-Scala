package notes.week4

abstract class Pure_Boolean {
  // if (cond) te then ee
  // cond.ifThenElse(te, ee)
  def ifThenElse[T](t: => T, e: => T): T

  def &&(x: => Boolean): Boolean = ifThenElse(x, false)

  def ||(x: => Boolean): Boolean = ifThenElse(true, x)

  def unary_! : Boolean = ifThenElse(false, true)

  def ==(x: Boolean): Boolean = ifThenElse(x, !x)

  def !=(x: Boolean): Boolean = ifThenElse(!x, x)

  def <(x: Boolean): Boolean = ifThenElse(false, x)
}

object True extends Pure_Boolean {
  override def ifThenElse[T](t: => T, e: => T): T = t
}

object False extends Pure_Boolean {
  override def ifThenElse[T](t: => T, e: => T): T = e
}
