package example

object Lists {

  /**
   *  - `xs.isEmpty: Boolean` returns `true` if the list `xs` is empty
   *  - `xs.head: Int` returns the head element of the list `xs`. If the list is empty an exception is thrown
   *  - `xs.tail: List[Int]` returns the tail of the list `xs`, i.e. the the list `xs` without its `head` element
   *
   * @param xs A list of natural numbers
   * @return The sum of all elements in `xs`
   */
  def sum(xs: List[Int]): Int = {
    if (xs.isEmpty)
      0
    else
      xs.head + sum(xs.tail)

    // xs.sum
  }

  /**
   * This method returns the largest element in a list of integers. If the
   * list `xs` is empty it throws a `java.util.NoSuchElementException`.
   *
   * You can use the same methods of the class `List` as mentioned above.
   *
   * ''Hint:'' Again, think of a recursive solution instead of using looping
   * constructs. You might need to define an auxiliary method.
   *
   * @param xs A list of natural numbers
   * @return The largest element in `xs`
   * @throws java.util.NoSuchElementException if `xs` is an empty list
   */
  def max(xs: List[Int]): Int = {
    if (xs.isEmpty)
      throw new java.util.NoSuchElementException();

    def find_max(current_max: Int, elements: List[Int]): Int = {
      if (elements.isEmpty)
        current_max
      else {
        val new_candidate = elements.head
        if (new_candidate > current_max)
          find_max(new_candidate, elements.tail)
        else
          find_max(current_max, elements.tail)
      }
    }

    find_max(xs.head, xs.tail)

    // xs.max
  }
}
