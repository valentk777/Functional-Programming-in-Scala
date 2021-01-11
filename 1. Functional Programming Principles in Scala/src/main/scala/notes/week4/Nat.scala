package notes.week4

// Peano numbers
// class imitate natural numbers
abstract class Nat {
  def isZero: Boolean

  // one number before current or exception if current is zero
  def predecessor: Nat

  // next number from current
  def successor: Nat = new Succ(this)

  def +(that: Nat): Nat

  def -(that: Nat): Nat
}

object Zero extends Nat {
  override def isZero: Boolean = true

  override def predecessor: Nat = throw new Error("current value is 0")

  override def +(that: Nat): Nat = that

  override def -(that: Nat): Nat = if (that.isZero) this else throw new Error("negative number")
}

class Succ(n: Nat) extends Nat {
  override def isZero: Boolean = false

  override def predecessor: Nat = n

  override def +(that: Nat): Nat = new Succ(n + that)

  //  override def +(that: Nat): Nat = if (that.isZero) this else new Succ(this) + that.predecessor

  override def -(that: Nat): Nat = if (that.isZero) this else n - that.predecessor
}

