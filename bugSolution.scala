```scala
class MyClass[T](val value: T) {
  def myMethod(implicit ev: T => Ordered[T]): T = value
}

object Main {
  implicit val intOrdering: Ordering[Int] = Ordering.Int
  implicit val stringOrdering: Ordering[String] = Ordering.String

  def main(args: Array[String]): Unit = {
    val myInt = new MyClass(10)
    println(myInt.myMethod)

    val myString = new MyClass("hello")
    println(myString.myMethod) // This now works
  }
}
```