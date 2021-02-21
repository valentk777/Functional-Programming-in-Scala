package calculator

object TweetLength extends TweetLengthInterface {
  final val MaxTweetLength = 140

  def tweetRemainingCharsCount(tweetText: Signal[String]): Signal[Int] =
    Signal(MaxTweetLength - tweetLength(tweetText()))

  /** Computes the length of a tweet, given its text string.
   * This is not equivalent to text.length, as tweet lengths count the number
   * of Unicode *code points* in the string.
   * Note that this is still a simplified view of the reality. Full details
   * can be found at
   * https://dev.twitter.com/overview/api/counting-characters
   *
   * This should be simply text.codePointCount(0, text.length), but it
   * is not implemented in Scala.js 0.6.2.
   */
  private def tweetLength(text: String): Int =
    if (text.isEmpty) 0
    else text.length - text.init.zip(text.tail).count((Character.isSurrogatePair _).tupled)

  def colorForRemainingCharsCount(remainingCharsCount: Signal[Int]): Signal[String] =
    Signal {
      val value = remainingCharsCount()
      if (value >= 15) "green"
      else if (value >= 0) "orange"
      else "red"
    }
}
