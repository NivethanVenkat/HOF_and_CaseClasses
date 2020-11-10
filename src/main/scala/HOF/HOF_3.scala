package HOF
//Appending
object HOF_3 {

  def numbers(x: Int, y: String, f: (Int, String) => String): String = f(x, y)

  def adding(x: Int, y: Int, z: Int, f: (Int, Int) => Int): Int = f(f(x, y), z)

  def main(args: Array[String]): Unit = {

    val input = numbers(46, " Rossi", _ + _)
    println(input)

    val input2 = adding(50, 50, 50, _ + _)
    println(input2)
  }
}
