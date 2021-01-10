package notes.week2

class Rational(x: Int, y: Int) {
  require(y != 0, "Denominator must be nonzero") // illegal argument exception
  assert(y != 0, "Denominator must be nonzero") // assertion error

  // another constructor for class Rational
  def this(x: Int) = this(x, 1)

  def numer: Int = x

  def denom: Int = y

  // we can name function name as +
  def +(that: Rational) =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom)

  def add(that: Rational) =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom)

  // we can name function name as -
  def -(that: Rational): Rational = this + that.neg

  def sub(that: Rational): Rational = add(that.neg)

  def *(that: Rational) =
    new Rational(
      numer * that.numer,
      denom * that.denom)

  def mul(that: Rational) =
    new Rational(
      numer * that.numer,
      denom * that.denom)

  def less(that: Rational): Boolean = numer * that.denom < that.numer * denom

  def <(that: Rational): Boolean = numer * that.denom < that.numer * denom

  def max(that: Rational): Rational = if (this < that) that else this

  // specific word unary_ to get a possibility to write -rational instead of rational.neg
  // ATTENTION: need to add space after name there, because : could be treated as a part of function as well
  def unary_- : Rational = new Rational(-numer, denom)

  def neg: Rational = new Rational(-numer, denom)

  override def toString: String = {
    val g = gcd(x, y)
    numer / g + "/" + denom / g
  }

  @scala.annotation.tailrec
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
}
