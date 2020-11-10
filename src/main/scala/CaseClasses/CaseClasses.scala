package CaseClasses

case class car (name: String = "Honda", segment: String = "SUV", model: Int = 2020) extends basicPart
class bike(name: String, model: Int) extends basicPart
class basicPart{
  def mileage (x: Int): Int = x
}

object CaseClasses {
  def main(args: Array[String]): Unit = {

    val company1 = car("Suzuki", "Sedan", 2010)
    val company2 = car("Suzuki", "SUV", 2010)

    println("Check companies are same: " + (company1 == company2))
    println("Mileage for vehicle is: " + company1.mileage(20))

    val company3 = new bike("RE", 2020)
    val company4 = new bike("RE", 2020)

    println("Check bike companies are same: " + (company3 == company4))

    val company5 = car()
    println(company5)

  }
}
