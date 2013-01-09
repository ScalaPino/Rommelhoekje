package nl.scalapino

import collection.JavaConverters._
import java.net.NetworkInterface
import scala.Array.canBuildFrom
import scala.Option.option2Iterable

object ListMACsForScala extends App {
  val nicaddresses = for {
    nic <- NetworkInterface.getNetworkInterfaces.asScala
    addrbytes <- Option(nic.getHardwareAddress)
  } yield {
    addrbytes map { "%02x" format _ } mkString ":"
  }
  nicaddresses foreach println
}
object dsds {

  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
}