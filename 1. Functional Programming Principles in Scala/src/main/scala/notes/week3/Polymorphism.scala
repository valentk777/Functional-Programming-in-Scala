package notes.week3

object Polymorphism {
  // Const-List - immutable linked list:
  // Nil - the empty list, Cons - a cell containing an element and the remainder of the list

  List(List(true, false), List(3))

  // Generic classes

  trait List[T] {
    def isEmpty: Boolean

    def head: T

    def tail: List[T]
  }

  class Cons[T](val head: T, val tail: List[T]) extends List[T] {
    def isEmpty: Boolean = false
  }

  class Nil[T] extends List[T] {
    def isEmpty = true

    def head: Nothing = throw new NoSuchElementException("Nil.head")

    def tail: Nothing = throw new NoSuchElementException("Nil.tail")
  }


  def singleton[T](elem: T) = new Cons[T](elem, new Nil[T])

  // both version there working, so you can ignore generic type parameter, because compiler do this automatically
  //  singleton[Int](1)
  //  singleton(1)

  /**
   * Polymorphism: we have seen two principal forms of polymorphism:
   * subtyping - instance of a subclass can be passed to a base class
   * generics - instance of a function or class are created byu type parameterization
   */

  /**
   * Write a function nth that takes an integer n and a list and selects the n'th element of the list.
   * Elements are numbered from 0.
   * If index is outside the range from 0 up to the length of the list minus one, a IndexOutOfBoundsException should be thrown.
   */
  @scala.annotation.tailrec
  def nth[T](n: Int, xs: List[T]): T = {
    if (xs.isEmpty) throw new IndexOutOfBoundsException()
    else if (n == 0) xs.head
    else nth(n - 1, xs.tail)



    //    if (length(listx) < n) listx[n] else throw new IndexOutOfBoundsException()
  }

}
