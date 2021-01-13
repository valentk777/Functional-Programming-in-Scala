package notes.week5

object Main extends App {
  def removeAt(n: Int, xs: List[Int]): List[Int] = (xs take n) ::: (xs drop n + 1)

  val nums = List(2, -7, 5, 12, -99)
  val foods = List("bread", "apple", "milk")

  println(mergeSortForInt.msort(nums))
  println(mergeSortGeneric.msort(nums)((x: Int, y: Int) => x < y))

  println(mergeSortGeneric.msortx(nums)(Ordering.Int))
  println(mergeSortGeneric.msortx(foods)(Ordering.String))

  // now we can remove ordering function, because compiler (based on type) will find ordering function automatically
  println(mergeSortImplicit.msort(nums))
  println(mergeSortImplicit.msort(foods))


  // maps
  println(maps.squareList(nums))
  println(maps.squareList2(nums))


  // filters
  println(nums filter (x => x > 0))
  println(nums filterNot (x => x > 0))

  // split into two lists based on filter parameter
  println(nums partition (x => x > 0))

  // take while take all element while pass condition
  println(nums takeWhile (x => x > 0))

  // drop while take all remaining element after first while pass condition
  println(nums dropWhile (x => x > 0))

  // pair of takeWhile and dropWhile
  println(nums span (x => x > 0))


  // pack should give List(List("a", "a", "a"), List("b"), List("c", "c"), List("a"))
  println(packs.pack(List("a", "a", "a", "b", "c", "c", "a")))

  // encode should give List(("a", 3), ("b", 1), ("c", 2), ("a", 1))
  println(encode.encode(List("a", "a", "a", "b", "c", "c", "a")))
}
