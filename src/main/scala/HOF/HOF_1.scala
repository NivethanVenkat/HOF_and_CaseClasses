package HOF
//Basic Mathematical operation
object HOF_1 {

  def addition(f:(Int, Int) => Int, a:Int, b: Int): Int = f(a, b)
  val SumOfSquares = (x: Int, y: Int) => (x*x + y*y)
  val SumOfCubes = (x: Int, y:Int) => (x*x*x + y*y*y)

  def main(args: Array[String]): Unit = {
    val SquaredSum = addition(SumOfSquares, 5, 5)
    val CubedSum = addition(SumOfCubes, 5, 5)

    println(SquaredSum)
    println(CubedSum)
  }
}
