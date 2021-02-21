package notes.week3

//trait LowPriorityImplicits {
//  implicit val intOrdering: Ordering[Int] = Ordering.Int
//}
//
//object Main extends LowPriorityImplicits {
//  implicit val intReverseOrdering: Ordering[Int] = Ordering.Int.reverse
//
//  def main(args: Array[String]): Unit = {
//    println(List(1, 2, 3).min)
//  }
//}

trait Show[A] {
  def apply(a: A): String
}
object Show {
  implicit val showInt: Show[Int] = new Show[Int] {
    def apply(n: Int): String = s"Int($n)"
  }
}

//implicitly[Show[Int]]
