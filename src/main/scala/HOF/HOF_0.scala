package HOF

//Map function
object HOF_0 {
  def doubleValue= (x:Int) => x*x
  def map (x:Int) = doubleValue(x)
  val list = List(1,2,3,4,5)

  def main(args: Array[String]): Unit = {
    val doubledValue = list.map(doubleValue)
    println(doubledValue)
  }
}
