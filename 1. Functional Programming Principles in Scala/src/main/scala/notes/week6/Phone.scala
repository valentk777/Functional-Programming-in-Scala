package notes.week6

object Phone {
  val words = List("All", "Possible", "Words")
  val mnem = Map(
    '2' -> "ABC",
    '3' -> "DEF",
    '4' -> "GHI",
    '5' -> "JKL",
    '6' -> "MNO",
    '7' -> "PQRS",
    '8' -> "TUV",
    '9' -> "WXYZ")

  // invert map from to letter to number
  val charCode: Map[Char, Char] =
    for ((digit, str) <- mnem; ltr <- str) yield ltr -> digit

  // from number to any possible word lists
//  val wordsForNum: Map[String, Seq[String]] = (for (w <- words) yield w.toUpperCase) groupBy wordCode withDefaultValue Seq()
  val wordsForNum2: Map[String, Seq[String]] = words.map(x => x.toUpperCase) groupBy wordCode withDefaultValue Seq()

  // Maps a word to the digit string in can represent. e.g. JAVA -> "5282"
  def wordCode(word: String): String = word.toUpperCase map charCode

  def encode(number: String): Set[List[String]] =
    if (number.isEmpty) Set(List())
    else {
      for {
        split <- 1 to number.length
        word <- wordsForNum2(number take split)
        rest <- encode(number drop split)
      } yield word :: rest
    }.toSet

  def translate(number: String): Set[String] =
    encode(number) map (_ mkString " ")
}
