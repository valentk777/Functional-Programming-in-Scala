package notes.week3.week2

import notes.week2.{FixedPointFunction, Rational}
import notes.week3.{Empty, NonEmpty}

/**
 * // how to import things
*import example.Lists
 **
 *// to import everything
*import example._
 **
 *// to import more than one
*import example.{Lists, SmthElse}
 */

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


  val t1 = new NonEmpty(3, new Empty, new Empty)
  val t2 = t1 incl 4
  val t3 = new NonEmpty(5, new NonEmpty(2, new Empty, new Empty), new NonEmpty(9, new Empty, new Empty))

  println(t1)
  println(t2)
  println(t1 union t3)

//  val listTest = new Cons(1, Cons(2, Cons(3, new Nil)))

}
