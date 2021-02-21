import notes.week5.{BankAccount, Consolidator}

object observerPattern {
  def main(args: Array[String]): Unit = {
    val a = new BankAccount
    val b = new BankAccount
    val c = new Consolidator(List(a, b))
    println(c.totalBalance)
    a.deposit(20)
    b deposit 30
    println(c.totalBalance)
  }
}