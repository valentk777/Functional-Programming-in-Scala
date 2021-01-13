package notes.week6

object Maps {
  // Maps same as dictionaries

  val romanNumerals = Map("I" -> 1, "V" -> 5, "X" -> 10)

  romanNumerals("I") // if not exist - throw exception

  romanNumerals get "I" // do not throw exception, but return None if not exist
  val random = List("avavasv", "bdascsa", "cvdadvd", "adadaa")

  // groupBy and orderBy; sortWith and sorted
  val p1 = new Poly(Map(0 -> 5.0, 1 -> -2.0, 3 -> 6.2))
  random groupBy (_.head) // return map where key is every first letter and value is a list of words starting with that letter

  // polynomial x^3-2x+5 can be represented with map
  Map(0 -> 5, 1 -> -2, 3 -> 1)

  //
  //  class Poly(val terms: Map[Int, Double]) {
  //    def +(other: Poly): Poly = new Poly(terms ++ (other.terms map adjust))
  //
  //    def adjust(term: (Int, Double)): (Int, Double) = {
  //      val (exp, coeff) = term
  //      terms get exp match {
  //        case Some(coeff1) => exp -> (coeff1 + coeff)
  //        case None => exp -> coeff
  //      }
  //    }
  //
  //    override def toString: String =
  //      (for ((exp, coeff) <- terms.toList.sorted.reverse) yield coeff + "x^" + exp) mkString " + "
  //  }
  //
  //  val p1 = new Poly(Map(0 -> 5.0, 1 -> -2.0, 3 -> 6.2))
  //  val p2 = new Poly(Map(1 -> 5.0, 5 -> 2.5))
  //
  //  p1 + p2

  // better way using default values
  // pass multiple parameters  using *
  //  class Poly(val terms0: Map[Int, Double]) {
  //    def this(bindings: (Int, Double)*) = this(bindings.toMap) // constructor to accept multiple pairs
  //
  //    val terms: Map[Int, Double] = terms0 withDefaultValue 0.0
  //
  //    def +(other: Poly): Poly = new Poly(terms ++ (other.terms map adjust))
  //
  //    def adjust(term: (Int, Double)): (Int, Double) = {
  //      val (exp, coeff) = term
  //      exp -> (coeff + terms(exp))
  //    }
  //
  //    override def toString: String =
  //      (for ((exp, coeff) <- terms.toList.sorted.reverse) yield coeff + "x^" + exp) mkString " + "
  //  }
  //
  //  val p1 = new Poly(Map(0 -> 5.0, 1 -> -2.0, 3 -> 6.2))
  //  val p2 = new Poly(1 -> 5.0, 5 -> 2.5) // use * and another constructor
  //
  //  p1 + p2
  val p2 = new Poly(1 -> 5.0, 5 -> 2.5) // use * and another constructor

  def showDictWithPatterMatching(numeral: String) = romanNumerals.get(numeral) match {
    case None => "missing data"
    case Some(num) => num
  }

  // using foldLeft. This one will be faster, because this one do not create temporary map
  class Poly(val terms0: Map[Int, Double]) {
    val terms: Map[Int, Double] = terms0 withDefaultValue 0.0

    def this(bindings: (Int, Double)*) = this(bindings.toMap) // constructor to accept multiple pairs

    def +(other: Poly): Poly = new Poly((other.terms foldLeft terms) (addTerm))

    def addTerm(terms: Map[Int, Double], term: (Int, Double)): Map[Int, Double] = {
      val (exp, coeff) = term
      terms + (exp -> (coeff + terms(exp)))
    }

    override def toString: String =
      (for ((exp, coeff) <- terms.toList.sorted.reverse) yield coeff + "x^" + exp) mkString " + "
  }

  p1 + p2
}
