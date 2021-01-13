package notes.week4

object Main extends App {

  val zero = Zero

  val succ_2 = new Succ(new Succ(Zero))

  println(succ_2)

  // A type error in line 2, because in scala there is no conversion for arrays
  //  val a: Array[NonEmpty] = Array(new NonEmpty(1, Empty, Empty))
  //  val b: Array[IntSet] = a
  //  b(0) = Empty
  //  val s: NonEmpty = a(0)


  //  def eval(e: Expression): Int = {
  //    if (e.isNumber) e.numValue
  //    else if (e.isSum) eval(e.leftOp) + eval(e.rightOp)
  //    else throw new Error("Unknown expression " + e)
  //  }

  //  def eval(e: Expression): Int = {
  //    if (e.isInstanceOf[Number])
  //      e.asInstanceOf[Number].numValue
  //    else if (e.isInstanceOf[Sum])
  //      eval(e.asInstanceOf[Sum].leftOp) +
  //        eval(e.asInstanceOf[Sum].rightOp)
  //    else throw new Error("Unknown expression " + e)
  //  }
  //
  //  println(this.eval(new Sum(new Number(1), new Number(2))))

  println(PatternMatching.eval(PatternMatching.Sum(PatternMatching.Number(1), PatternMatching.Number(2))))
  println(PatternMatching.show(PatternMatching.Sum(PatternMatching.Number(1), PatternMatching.Number(2))))
}
