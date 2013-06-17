package com.micronautics.implicitFun

case class Person(name: String, age: Int)

case class Restaurant(name: String, brunch: Boolean)

trait Serializable[T] {
  def ser(t: T): String
}

object Main extends App {
  val mike = Person("Mike", 56)
  val alices = Restaurant("Alice's", brunch = true)

  implicit object PersonIsSerializable extends Serializable[Person] {
    def ser(p: Person) = p.toString
  }

  implicit object RestaurantIsSerializable extends Serializable[Restaurant] {
    def ser(r: Restaurant) = r.toString
  }

  def serialize[T](t: T)(implicit s: Serializable[T]) = s.ser(t)

  println(serialize(mike))
  println(serialize(alices))


  // add serialize extension method to domain classes:
  implicit def addSerialize[T](t:T)(implicit s: Serializable[T]) =
    new { def serialize = s.ser(t) }

  println(mike.serialize)
  println(alices.serialize)


  val ellen = Person("Ellen", 55)
  val fred = Person("Fred", 20001)
  val wilma = Person("Wilma", 20000)
  val people = List(mike, ellen, fred, wilma)

  implicit val ByAge: Ordering[Person] = Ordering.by(_.age)
  implicit val ByName: Ordering[Person] = Ordering.by(_.name)

  println("Sort by age: " + people.sorted(ByAge))
  println("Sort by name: " + people.sorted(ByName))
}
