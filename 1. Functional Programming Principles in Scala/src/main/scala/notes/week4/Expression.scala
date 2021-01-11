package notes.week4

trait Expression {
  def isNumber: Boolean

  def isSum: Boolean

  def numValue: Int

  def leftOp: Expression

  def rightOp: Expression
}

class Number(n: Int) extends Expression {
  override def isNumber: Boolean = true

  override def isSum: Boolean = false

  override def numValue: Int = n

  override def leftOp: Expression = throw new Error("Number.leftOp")

  override def rightOp: Expression = throw new Error("Number.rightOp")
}

class Sum(e1: Expression, e2: Expression) extends Expression {
  override def isNumber: Boolean = false

  override def isSum: Boolean = true

  override def numValue: Int = throw new Error("Sum.numValue")

  override def leftOp: Expression = e1

  override def rightOp: Expression = e2
}
