package objsets

import org.junit.Assert.assertEquals
import org.junit._

class TweetSetSuite {

  trait TestSets {
    val set1 = new Empty
    val set2: TweetSet = set1.incl(new Tweet("a", "a body", 20))
    val set3: TweetSet = set2.incl(new Tweet("b", "b body", 20))
    val c = new Tweet("c", "c body", 7)
    val d = new Tweet("d", "d body", 9)
    val set4c: TweetSet = set3.incl(c)
    val set4d: TweetSet = set3.incl(d)
    val set5: TweetSet = set4c.incl(d)

    val set_test = new NonEmpty(new Tweet("a", "a body", 1), set5, set3)
  }

  def asSet(tweets: TweetSet): Set[Tweet] = {
    var res = Set[Tweet]()
    tweets.foreach(res += _)
    res
  }

  def size(set: TweetSet): Int = asSet(set).size

  @Test def `filter: on empty set`: Unit =
    new TestSets {
      assertEquals(0, size(set1.filter(tw => tw.user == "a")))
    }

  @Test def `filter: a on set5`: Unit =
    new TestSets {
      assertEquals(1, size(set5.filter(tw => tw.user == "a")))
    }

  @Test def `filter: twenty on set5`: Unit =
    new TestSets {
      assertEquals(2, size(set5.filter(tw => tw.retweets == 20)))
    }

  @Test def `union: set4c and set4d`: Unit =
    new TestSets {
      assertEquals(4, size(set4c.union(set4d)))
    }

  @Test def `union: with empty set1`: Unit =
    new TestSets {
      assertEquals(4, size(set5.union(set1)))
    }

  @Test def `union: with empty set2`: Unit =
    new TestSets {
      assertEquals(4, size(set1.union(set5)))
    }

  @Test def `most retweets: set6`: Unit =
    new TestSets {
      set_test.foreach(println)

      val trend: Tweet = set_test.mostRetweeted
      println(trend)
    }

  @Test def `descending: set5`: Unit =
    new TestSets {
      val trends: TweetList = set5.descendingByRetweet
      assert(!trends.isEmpty)
      assert(trends.head.user == "a" || trends.head.user == "b")
    }


  @Rule def individualTestTimeout = new org.junit.rules.Timeout(10 * 1000)
}
