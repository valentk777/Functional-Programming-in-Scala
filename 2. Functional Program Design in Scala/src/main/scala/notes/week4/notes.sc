for (i <- 1 until 3; j <- "abc") println(i + " " + j)

(1 until 3) foreach (i => "abc" foreach (j => println(i + " " + j)))

// val - cannot be changed

// var - can be changed

val not_changed = 5
//not_changed = 6     // error

var can_changed = 5
can_changed = 6



