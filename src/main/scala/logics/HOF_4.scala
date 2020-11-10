package logics

import scala.annotation.tailrec

object HOF_4 {
  def operateList(list: List[Int], f: (Int, Int) => Int, operation: String): Int = {
    @tailrec
    def inner(list: List[Int], result: Int): Int = {
      list match {
        case head :: tail => inner(tail, f(head, result))
        case Nil => result
      }
    }

    operation.toLowerCase match {
      case "product" => inner(list, 1)
      case "sum" => inner(list, 0)
    }
  }

  def main(args: Array[String]): Unit = {
    val result = operateList(List(1,2,3),(a,b)=>a+b,"sum")
    println(result)
  }
}
