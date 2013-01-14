package nl.scalapino

abstract class Dimension[T](val value: Double, val name: String, val coef: Double) {
  self: T =>
  protected def create(value: Double, name: String, coef: Double): T
  def +(x: Dimension[T]): T = create(value + coef * x.value / x.coef, name, coef)
  def -(x: Dimension[T]): T = create(value - coef * x.value / x.coef, name, coef)
  override def toString(): String = value + " " + name
}

class Time(value: Double, name: String, coef: Double)
    extends Dimension[Time](value, name, coef) {
  protected def create(a: Double, b: String, c: Double) = new Time(a, b, c)
}

class Length(value: Double, name: String, coef: Double)
    extends Dimension[Length](value, name, coef) {
  protected def create(a: Double, b: String, c: Double) = new Length(a, b, c)
}

class Mass(value: Double, name: String, coef: Double)
    extends Dimension[Mass](value, name, coef) {
  protected def create(a: Double, b: String, c: Double) = new Mass(a, b, c)
}

abstract class TimeUnit(name: String, coef: Double) {
  def apply(value: Double) = new Time(value, name, coef)
  def apply(orig: Time) = new Time(0, name, coef) + orig
}

object Second extends TimeUnit("seconds", 1.0)
object Minute extends TimeUnit("minutes", 1.0 / 60)
object Hour extends TimeUnit("hours", 1.0 / 3600)

abstract class LengthUnit(name: String, coef: Double) {
  def apply(value: Double) = new Length(value, name, coef)
  def apply(orig: Length) = new Length(0, name, coef) + orig
}

object Meter extends LengthUnit("meters", 1.0)
object Inch extends LengthUnit("inches", 1.0 / .0254)
object Foot extends LengthUnit("feet", 1.0 / .0254 / 12)

