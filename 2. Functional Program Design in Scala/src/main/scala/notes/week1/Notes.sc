//val f: String => String = {
//  case "one" => "two"
//}
//
//
//f("one")
//
//// error
//// f("nesamas")
//
//// we can solve this by defining better base class
//
//val g: PartialFunction[String, String] = {
//  case "one" => "two"
//}
//
//g.isDefinedAt("one")
//g.isDefinedAt("nesamas")
//
//// random values
//import java.util.Random
//
//val rand = new Random()
//rand.nextBoolean()


def expressionMatter(a: Int, b: Int, c: Int): Int =
  List(
    a + b + c,
    a * b + c,
    a + b * c,
    a * (b + c),
    (a + b) * c,
    a * b * c).max


expressionMatter(3,5,7)
//  max(a + b + c, a*b+c, a+b*c, a*(b+c), (a+b)*c)
