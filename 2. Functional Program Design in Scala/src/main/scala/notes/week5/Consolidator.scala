package notes.week5

class Consolidator(observed: List[BankAccount]) extends Subscriber {
  observed.foreach(_.subscribe(this))

  private var total: Int = _
  compute()

  def handler(pub: Publisher) = compute()

  private def compute() = {
    total = observed.map(_.currentBalance).sum
  }

  def totalBalance = total
}