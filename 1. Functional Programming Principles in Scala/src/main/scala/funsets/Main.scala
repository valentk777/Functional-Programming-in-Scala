package funsets

object Main extends App {

  import FunSets._

  val my_set = singletonSet(1)
  println(my_set)
  println(contains(my_set, 1))

  val s1 = singletonSet(1)
  val s2 = singletonSet(3)
  val s3 = singletonSet(5)

  val multiple_sets = union(union(s1, s2), s3)
  println(forall(multiple_sets, x => x > 0))
  println(exists(multiple_sets, x => x == 5))

  printSet(filter(multiple_sets, x => x < 5))
  printSet(map(multiple_sets, x => x - 1))
}
