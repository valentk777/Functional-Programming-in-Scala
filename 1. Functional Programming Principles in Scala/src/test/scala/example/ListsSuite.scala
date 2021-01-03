package example

import example.Lists._
import org.junit.Assert.assertEquals
import org.junit._

// JUnit test suite; run this test suite, start "sbt" then run the "test" command.
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

  @Test def `sum of positive numbers (10pts)`: Unit = {
    assertEquals(sum(List(1, 2, 5, 0)), 8)
  }

  @Test def `sum of negative numbers (10pts)`: Unit = {
    assertEquals(sum(List(-1, -2, -5)), -8)
  }

  @Test def `sum of negative and positive numbers (10pts)`: Unit = {
    assertEquals(sum(List(-1, 2, -2)), -1)
  }

  @Test def `sum of empty array (10pts)`: Unit = {
    assertEquals(sum(List()), 0)
  }

  @Test def `sum of repeated elements (10pts)`: Unit = {
    assertEquals(sum(List(1, 1, 1)), 3)
  }

  @Test def `max of a positive numbers (10pts)`: Unit = {
    assertEquals(max(List(3, 15, 2)), 15)
  }

  @Test def `max of a negative numbers (10pts)`: Unit = {
    assertEquals(max(List(-3, -7, -2)), -2)
  }

  @Test def `max of a positive and negative numbers (10pts)`(): Unit = {
    assertEquals(max(List(-3, 7, -2)), 7)
  }

  @Test def `max of repeated numbers (10pts)`: Unit = {
    assertEquals(max(List(-2, -2, 4, 4)), 4)
  }

  @Test def `max of empty list (10pts)`: Unit = {
    try {
      max(List())
      Assert.fail("No exception has been thrown")
    } catch {
      case e: NoSuchElementException => ()
    }
  }

  @Rule def individualTestTimeout = new org.junit.rules.Timeout(1000)
}
