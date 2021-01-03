package recfun

object RecFun extends RecFunInterface {

  def main(args: Array[String]): Unit = {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(s"${pascal(col, row)} ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int =
    if (c < 0 || r < 0 || c > r) 0
    else if (c == 0 || c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def calculate(current_number: Int, letters: List[Char]): Int = {
      if (letters.isEmpty)
        current_number
      else {
        val candidate = letters.head

        if (candidate == '(')
          calculate(current_number + 1, letters.tail)
        else if (candidate == ')' && current_number != 0)
          calculate(current_number - 1, letters.tail)
        else if (candidate == ')')
          -1
        else
          calculate(current_number, letters.tail)
      }
    }

    calculate(0, chars) == 0
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int =
    if (money < 0 || coins.isEmpty)
      0
    else if (money == 0)
      1
    else
      countChange(money - coins.head, coins) + countChange(money, coins.tail)
}
