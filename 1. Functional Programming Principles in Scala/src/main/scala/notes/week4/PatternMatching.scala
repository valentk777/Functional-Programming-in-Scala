package notes.week4

object PatternMatching {

  trait Expr

  case class Number(n: Int) extends Expr

  case class Sum(e1: Expr, e2: Expr) extends Expr

  object Number {
    def apply(n: Int) = new Number(n)
  }

  object Sum {
    def apply(e1: Expr, e2: Expr) = new Sum(e1, e2)
  }

  def eval(e: Expr): Int = e match {
    case Number(n) => n
    case Sum(e1, e2) => eval(e1) + eval(e2)
  }

  def show(e: Expr): String = e match {
    case Number(n) => n.toString
    case Sum(e1, e2) => show(e1) + " + " + show(e2)
  }
}
