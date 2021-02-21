//implicit val n: Int = 42
//def f(implicit x: Int) = x
//println(f)
//
//implicit val n: Int = 42
//def f(implicit x: Int) = x
//println(f(0))

//implicit val world: String = "World"
//def greet(implicit name: String) = s"Hello, $name!"
//println(greet)

//trait Show[A] {
//  def apply(a: A): String
//}
//object Show {
//  implicit val showInt: Show[Int] = new Show[Int] {
//    def apply(n: Int): String = s"Int($n)"
//  }
//}

//implicitly[Show[Int]](implicit Show[Int]: Show[Int])
//implicitly[Show[Int]]

//trait Show[A] {
//  def apply(a: A): String
//}
//object Show {
//  implicit val showInt: Show[Int] = new Show[Int] {
//    def apply(n: Int): String = s"Int($n)"
//  }
//}
//def printValue[A: Show](a: A): Unit = {
//  println(implicitly[Show[A]].apply(a))
//}
//printValue(42)

//trait Physics {
//  implicit def air: Gaz
//  implicit def condense(implicit gaz: Gaz): Liquid
//  implicit def freeze(implicit liquid: Liquid): Solid
//
//  implicitly[Solid]
//}

//import scala.language.implicitConversions
//
//case class Rational(numerator: Int, denominator: Int)
//
//object Rational {
//  implicit def fromInt(n: Int) = Rational(n, 1)
//}
//
//val r: Rational = 42
//println(r)

import scala.language.implicitConversions

implicit class HasIsEven(n: Int) {
  def isEven: Boolean = n % 2 == 0
}

42.isEven


//implicitly[Solid](freeze(condense(air)))

//def implicitly[T](implicit e: T): T = e
//implicitly[T](e: T): T = e