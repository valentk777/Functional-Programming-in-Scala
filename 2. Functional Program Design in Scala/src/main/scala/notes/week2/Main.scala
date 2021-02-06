package notes.week2

object Main extends App {
  val problem = new Pouring(Vector(4, 7))
//  println(problem.moves)
//  println(problem.pathSets.take(3).toList)

  println(problem.solution(6))
}
