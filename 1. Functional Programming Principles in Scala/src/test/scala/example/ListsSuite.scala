package example

import org.junit.Assert.assertEquals
import org.junit._

/**
 * a JUnit test suite; run this test suite, start "sbt" then run the "test" command.
 */
class ListsSuite {
  @Test def `one plus one is two (0pts)`: Unit = {
    assertEquals(1 + 1, 2)
  }

  /**
   * Exceptional behavior of a methods can be tested using a try/catch
   * and a failed assertion.
   *
   * In the following example, we test the fact that the method `intNotZero`
   * throws an `IllegalArgumentException` if its argument is `0`.
   */
  @Test def `intNotZero throws an exception if its argument is 0`: Unit = {
    try {
      intNotZero(0)
      Assert.fail("No exception has been thrown")
    } catch {
      case e: IllegalArgumentException => ()
    }
  }

  def intNotZero(x: Int): Int = {
    if (x == 0) throw new IllegalArgumentException("zero is not allowed")
    else x
  }

  /**
   * Now we finally write some tests for the list functions that have to be
   * implemented for this assignment. We fist import all members of the
   * `List` object.
   */


  /**
   * We only provide two very basic tests for you. Write more tests to make
   * sure your `sum` and `max` methods work as expected.
   *
   * In particular, write tests for corner cases: negative numbers, zeros,
   * empty lists, lists with repeated elements, etc.
   *
   * It is allowed to have multiple `assert` statements inside one test,
   * however it is recommended to write an individual `test` statement for
   * every tested aspect of a method.
   */
  //  @Test def `sum of a few numbers (10pts)`: Unit = {
  //    assertEquals(sum(List(1, 2, 0)), 3)
  //  }
  //
  //  @Test def `max of a few numbers (10pts)`: Unit = {
  //    assertEquals(max(List(3, 7, 2)), 7)
  //  }


  @Rule def individualTestTimeout = new org.junit.rules.Timeout(1000)
}
