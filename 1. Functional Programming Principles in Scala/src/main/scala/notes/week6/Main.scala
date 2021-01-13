package notes.week6

object Main extends App {
  /**
   * Hierarchy of Iterable:
   * Iterable
   * /       |      \
   * Seq        Set     Map
   * /     |   \
   * List  Vector  Range
   *
   * Array and String (could be used as Seq)
   *
   */

  println((Sets.queens(8) map Sets.show) mkString "\n")
}
