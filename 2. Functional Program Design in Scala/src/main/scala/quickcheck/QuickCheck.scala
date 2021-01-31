package quickcheck

import org.scalacheck.Arbitrary._
import org.scalacheck.Gen._
import org.scalacheck.Prop._
import org.scalacheck._

abstract class QuickCheckHeap extends Properties("Heap") with IntHeap {

  lazy val genHeap: Gen[H] = for {
    a <- arbitrary[Int]
    h <- oneOf(const(empty), genHeap)
  } yield insert(a, h)

  implicit lazy val arbHeap: Arbitrary[H] = Arbitrary(genHeap)

  property("gen1") = forAll { (h: H) =>
    val m = if (isEmpty(h)) 0 else findMin(h)
    findMin(insert(m, h)) == m
  }

  property("min1") = forAll { (a: A) =>
    val h = insert(a, empty)
    findMin(h) == a
  }

  property("min2") = forAll { (a: A, b: A) =>
    val h = insert(b, insert(a, empty))
    findMin(h) == Math.min(a, b)
  }

  //  property("minN") = forAll { (l: List[A]) =>
  //    case class BH(b: Boolean, h: H)
  //
  //    val h = l.foldLeft(empty) { (h: H, a: A) => insert(a, h) }
  //
  //    val res = l.sorted.foldLeft(BH(true, h)) {
  //      (bh: BH, a: A) => BH(bh.b && findMin(bh.h) == a, deleteMin(bh.h))
  //    }
  //    res.b && isEmpty(res.h)
  //  }

  property("insertAndDeleteThen") = forAll { (n: A) =>
    isEmpty(deleteMin(insert(n, empty)))
  }

  property("deleteMinAlwaysDeleteMinValue") = forAll { (h: H) =>
    @scala.annotation.tailrec
    def isSorted(h: H): Boolean =
      if (isEmpty(h)) true
      else {
        val m = findMin(h)
        val h2 = deleteMin(h)
        isEmpty(h2) || (m <= findMin(h2) && isSorted(h2))
      }

    isSorted(h)
  }

  property("minOfTwoMeldingHeaps") = forAll { (h1: H, h2: H) =>
    findMin(meld(h1, h2)) == Math.min(findMin(h1), findMin(h2))
  }

  //  property("meld") = forAll { (h1: H, h2: H) =>
  //    def heapEqual(h1: H, h2: H): Boolean =
  //      if (isEmpty(h1) && isEmpty(h2)) true
  //      else {
  //        val m1 = findMin(h1)
  //        val m2 = findMin(h2)
  //        m1 == m2 && heapEqual(deleteMin(h1), deleteMin(h2))
  //      }
  //
  //    heapEqual(meld(h1, h2),
  //      meld(deleteMin(h1), insert(findMin(h1), h2)))
  //  }

  property("empty1") = forAll { a: A =>
    val h = insert(a, empty)
    isEmpty(deleteMin(h))
  }
}