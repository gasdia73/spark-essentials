package part1recap

import scala.concurrent.Future
import scala.util.{Failure, Success}

object ScalaRecap {

  val ifexpr = if (3 > 2) "bigger" else "smaller"


  val incrementer: Int => Int = x => x + 1

  val processedList = List(3, 4, 5).map(incrementer)

  //pattern matching
  val unknown: Any = 3
  val ordinal = unknown match {
    case 1 => "first"
    case 2 => "second"
    case _ => "unknown"
  }

  //future

  import scala.concurrent.ExecutionContext.Implicits.global

  val aFuture = Future {
    //computation on another thread
    42
  }

  aFuture.onComplete {
    case Success(meaningOfLife) => println(s"The meaning of life is $meaningOfLife")
    case Failure(exception) => println(s"Something went wrong: $exception")
  }

  //partial functions
  val aPartialFunction: PartialFunction[Int, Int] = {
    case 3 => 42
    case 4 => 2
    case _ => 999
  }

  //implicits
  def methodWithImplicit(implicit x:Int) = x +44
  implicit val implicitValue = 42

  methodWithImplicit

  //implicit conversions - implicit defs
  case class Person(name: String) {
    def greet: String = s"Hello, $name"
  }
  implicit def fromStringToPerson(name: String): Person = Person(name)
  "Fiona".greet

  //implicit conversions - implicit classes
  implicit class Dog(name: String) {
    def bark = "bark"
  }
  "Fufi".bark

}
