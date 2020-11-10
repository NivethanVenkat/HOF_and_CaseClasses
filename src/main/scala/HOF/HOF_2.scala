package HOF
//Applying Pattern to text
object HOF_2 {
  def applyPattern(text:String, f:String => String): String = f(text)
  def appendTag(data:String): String => String = { _:String => s"$data"}

  def main(args: Array[String]): Unit = {
    val message = "scala"
    println(applyPattern(message, appendTag(message)))
  }
}
