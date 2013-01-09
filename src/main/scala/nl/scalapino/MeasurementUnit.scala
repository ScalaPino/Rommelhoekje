package nl.scalapino

object MeasurementUnit {
  val miFactor = .254
  trait Distance extends Any { // Universal trait
  }
  implicit def inch2meter(x: Inch) = new Meter(x.value * miFactor)
  implicit def meter2inch(x: Meter) = new Inch(x.value / miFactor)

  case class Meter(val value: Double) extends Distance {
    def +(m: Meter) = new Meter(value + m.value)
    override def toString = value.toString + 'm'
  }

  case class Inch(val value: Double) extends Distance {
    def +(m: Inch) = new Inch(value + m.value)
    override def toString = value.toString + '"'
  }

  trait Temperature extends Any // Universal trait
  val cfFactor = 5.0 / 9.0
  val cOffset = 32.0
  val kOffset = 273.15

  implicit def Fahrenheit2Kelvin(x: Fahrenheit) =
    new Kelvin(cfFactor * (x.fTemp - cOffset) + kOffset)
  implicit def Fahrenheit2Celcius(x: Fahrenheit) =
    new Celcius(cfFactor * (x.fTemp - cOffset))
  implicit def Celcius2Kelvin(x: Celcius) =
    new Kelvin(x.cTemp + kOffset)
  implicit def Celcius2Fahrenheit(x: Celcius) =
    new Fahrenheit((x.cTemp / cfFactor) + cOffset)
  implicit def Kelvin2Celcius(x: Kelvin) =
    new Celcius((x.kTemp - kOffset)) //
  implicit def Kelvin2Fahrenheit(x: Kelvin) =
    new Fahrenheit(((x.kTemp - kOffset) / cfFactor) + 32)

  case class Fahrenheit(val fTemp: Double) extends Temperature {
    def +(m: Fahrenheit) = new Fahrenheit(fTemp + m.fTemp)
    override def toString = fTemp.toString + "°F"
  }
  case class Celcius(val cTemp: Double) extends Temperature {
    def +(m: Celcius) = new Celcius(cTemp + m.cTemp)
    override def toString = cTemp.toString + "°C"
  }
  case class Kelvin(val kTemp: Double) extends Temperature {
    def +(m: Kelvin): Kelvin = new Kelvin(kTemp + m.kTemp)
    override def toString = kTemp.toString + 'K'
  }

  def main(args: Array[String]): Unit = {
    val inch: Meter = Inch(1)
    val meter: Inch = Meter(1)
    println(Inch(1) + " = " + inch)
    println(Meter(1) + " = " + meter)

    println(Celcius(0).toString + " = " + (Celcius(0): Fahrenheit) + " = " + (Celcius(0): Kelvin))
    println((Fahrenheit(0): Celcius).toString + " = " + (Fahrenheit(0): Fahrenheit) + " = " + (Fahrenheit(0): Kelvin))

    println((Kelvin(0): Celcius).toString + " = " + (Kelvin(0): Fahrenheit) + " = " + (Kelvin(0): Kelvin))
    println(Celcius(100).toString + " = " + (Celcius(100): Fahrenheit) + " = " + (Celcius(100): Kelvin))

  }
}