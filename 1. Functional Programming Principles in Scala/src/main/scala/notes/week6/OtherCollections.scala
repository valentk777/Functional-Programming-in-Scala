package notes.week6

class OtherCollections {
  // List
  val c_ = List(1, 2, 3)
  val _ = List(1, 2, 3) :: List(1, 2, 3)

  // Vector (same commands as list)
  val _ = Vector(1, 2, 3)
  // only different how we join two of them
  val _ = Vector(1, 2, 3) +: Vector(1, 2, 3)
  val _ = Vector(1, 2, 3) :+ Vector(1, 2, 3)

  // Ranges
  val _: Range = 1 until 5 // 1, 2, 3, 4
  val _: Range = 1 to 5 // 1, 2, 3, 4, 5
  val _: Range = 1 to 10 by 3 // 1, 4, 7, 10
  val _: Range = 6 to 1 by -2 // 6, 4, 2

  // collections commands
  val _ = "LabasRytas" flatMap (x => List(".", x)) // .L.a.b.a.s. ...

  val pairs_x = List(1, 2, 3) zip List("a", "b", "c")
  pairs_x.unzip

  "LabasRytas" forall (x => x.isUpper) // true if all pass, else if not
}
