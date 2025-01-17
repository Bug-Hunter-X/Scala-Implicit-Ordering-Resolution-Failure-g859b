```scala
class MyClass[T](val value: T) {
  def myMethod(implicit ev: T => Ordered[T]): T = value
}

object Main {
  implicit val intOrdering: Ordering[Int] = Ordering.Int

  def main(args: Array[String]): Unit = {
    val myInt = new MyClass(10)
    println(myInt.myMethod)

    val myString = new MyClass("hello")
    println(myString.myMethod) // This line will cause a compile-time error
  }
}
```