(1 to 100).toStream

// create only first element, and then create second if needed
def streamRange(lo: Int, hi: Int): Stream[Int] =
  if (lo >= hi) Stream.empty
  else Stream.cons(lo, streamRange(lo + 1, hi))

streamRange(1, 5)

// create a whole list
def listRange(lo: Int, hi: Int): List[Int] =
  if (lo >= hi) Nil
  else lo :: listRange(lo + 1, hi)


listRange(1, 5)

// x :: xs - is always produce a list, never stream
// x #:: xs - produce a stream instead of list

val x = Stream(1, 2, 3, 4) //> x  : scala.collection.immutable.Stream[Int] = Stream(1, ?)
10 #:: x


def k: Int => Int = (x: Int) => x * x // every time it was called, every time it was evaluated
lazy val k_lazy = (x: Int) => x * x // evaluated AND CACHED at a time it was called

// example
def expr = {
  val x = {
    print("x")
    1
  }
  lazy val y = {
    print("y")
    2
  }

  def z = {
    print("z")
    3
  }

  z + y + x + z + y + x
}

expr
// first val will be called, and print x
// y is lazy, so do not call now
// first called z, so as a result xz printed for now
// then called y. so, xzy printed
// then z called and printed xzyz
// y already evaluated, so only it value was used (2)
// x already evaluated, so it value was used (1)
// answer: xzyz

// infinite streams
def from(n: Int): Stream[Int] = n #:: from(n + 1)

// get all prime numbers using technique:
// take first prime number (2) and remove repetitive numbers (4, 6, 8, ..)
// then select second number (3). It is prime and remove repetitive (6, 9, 12, ..)

def sieve(s: Stream[Int]): Stream[Int] =
  s.head #:: sieve(s.tail filter (_ % s.head != 0))

val primes = sieve(from(2))

primes.take(100).toList

def sqrtStream(x: Double): Stream[Double] = {
  def improve(guess: Double) = (guess + x / guess) / 2

  lazy val guesses: Stream[Double] = 1 #:: (guesses map improve)

  guesses
}


sqrtStream(4).take(10).toList
sqrtStream(3).take(10).toList







