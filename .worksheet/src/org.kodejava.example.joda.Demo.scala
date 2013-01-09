package org.kodejava.example.joda

import org.joda.time.DateMidnight
import org.joda.time.DateTimeConstants.FRIDAY

object Demo {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(164); 
  val pattern = "w E yyyy-MM-dd";System.out.println("""pattern  : java.lang.String = """ + $show(pattern ));$skip(284); 

  def fridaySieve(date: DateMidnight, endDate: DateMidnight, list: List[DateMidnight]): List[DateMidnight] = {
    if (date.isAfter(endDate)) list
    else fridaySieve(date.plusDays(7), endDate,
      if (date.dayOfMonth().get == 13)
        list ++ List(date)
      else list)
  };System.out.println("""fridaySieve: (date: org.joda.time.DateMidnight, endDate: org.joda.time.DateMidnight, list: List[org.joda.time.DateMidnight])List[org.joda.time.DateMidnight]""");$skip(31); 
  val now = new DateMidnight();System.out.println("""now  : org.joda.time.DateMidnight = """ + $show(now ));$skip(136); val res$0 = 

  fridaySieve(
    now.plusDays(FRIDAY - now.getDayOfWeek()),
    now.plusDays(600),
    Nil).map(_.toString(pattern)).mkString("\n");System.out.println("""res0: String = """ + $show(res$0))}
}