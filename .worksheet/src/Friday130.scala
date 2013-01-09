import scala.annotation.tailrec
import org.joda.time.DateMidnight
import org.joda.time.DateTimeConstants.FRIDAY
import org.joda.time.base.AbstractInstant

object Friday130 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(470); 


  def fridaySieve(date: DateMidnight,
    endDate: DateMidnight,
    list: List[DateMidnight]): List[DateMidnight] =
    {
      if (date isAfter endDate) list
      else fridaySieve(date.plusDays(7),
        endDate,
        if (date.dayOfMonth().get == 13) list ++ List(date) else list)
    };System.out.println("""fridaySieve: (date: org.joda.time.DateMidnight, endDate: org.joda.time.DateMidnight, list: List[org.joda.time.DateMidnight])List[org.joda.time.DateMidnight]""");$skip(91); 

  val startDatum = new DateMidnight().withYear(1990).withMonthOfYear(1).withDayOfMonth(1);System.out.println("""startDatum  : org.joda.time.DateMidnight = """ + $show(startDatum ));$skip(90); 
  val endDatum = new DateMidnight().withYear(2020).withMonthOfYear(12).withDayOfMonth(31);System.out.println("""endDatum  : org.joda.time.DateMidnight = """ + $show(endDatum ));$skip(23); val res$0 = 
   endDatum.toString();System.out.println("""res0: java.lang.String = """ + $show(res$0));$skip(75); 
  //def main(args: Array[String]) =
   
    val pattern = "w E yyyy-MM-dd";System.out.println("""pattern  : java.lang.String = """ + $show(pattern ));$skip(151); 

    val a = fridaySieve(
      startDatum.plusDays(FRIDAY - startDatum.getDayOfWeek()), endDatum, Nil).
      groupBy(_.getYear()).toSeq.sortBy(_._1);System.out.println("""a  : Seq[(Int, List[org.joda.time.DateMidnight])] = """ + $show(a ))}
    //println(a.mkString("\n"))
  
}