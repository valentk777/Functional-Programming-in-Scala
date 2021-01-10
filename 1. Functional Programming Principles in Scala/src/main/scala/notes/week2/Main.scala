package notes.week2

object Main extends App {
  println(FixedPointFunction.sqrt(2))

  val x = new Rational(1, 3)
  val y = new Rational(5, 7)
  val z = new Rational(3, 2)
  println(x.add(y).mul(z).toString())

  // another way to write class function parameter
  x add y
  x less z
  x max z
  // it return same as x.add(y), x.less(z) and x.max(z)

}
