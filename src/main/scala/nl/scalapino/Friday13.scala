package nl.scalapino

import scala.annotation.tailrec
import org.joda.time.{ DateMidnight, DateTime }
import org.joda.time.DateTimeConstants.FRIDAY

object Friday13 {

  def getFriday13s(sDatum: DateTime, eDatum: DateTime) = {
    @tailrec def fridaySieveIter(date: DateTime, list: List[DateTime]): List[DateTime] =
      {
        if (date isAfter eDatum) list else fridaySieveIter(date.plusDays(7),
          if (date.dayOfMonth().get == 13) list ++ List(date) else list)
      }
    fridaySieveIter(sDatum.plusDays(FRIDAY - sDatum.getDayOfWeek()), Nil)
  } // friday13Sieve(startDatum: DateTime, endDatum: DateTime)

  val startDatum = new DateMidnight().withYear(1990).withMonthOfYear(1).withDayOfMonth(1).toDateTime()
  val endDatum = startDatum.withYear(2020).withMonthOfYear(12).withDayOfMonth(31).toDateTime()

  def main(args: Array[String]) {
    val pattern = "yyyy-MM-dd"

    val grouped: Seq[(Int, List[org.joda.time.DateTime])] =
      getFriday13s(startDatum, endDatum).groupBy(_.getYear()).toSeq.sortBy(_._1)
    println(grouped.map(tuple => (tuple._1, tuple._2.map(_.toString(pattern)).mkString(" Friday: ", ", ", ""))).
      mkString("Fridays 13th " + startDatum.toString(pattern) + " - " + endDatum.toString(pattern) + "\n",
        "\n", "\nEnd of list"))
  }
}