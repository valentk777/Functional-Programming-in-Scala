package notes.week4

trait Expression2 {
  def eval: Int
}

class Number2(n: Int) extends Expression2 {
  override def eval: Int = n
}

class Sum2(e1: Expression2, e2: Expression2) extends Expression2 {
  override def eval: Int = e1.eval + e2.eval
}
