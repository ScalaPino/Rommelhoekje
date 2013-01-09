object Inputtestje {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(39); 
  var max: Int = 0;System.out.println("""max  : Int = """ + $show(max ));$skip(33); 
  print("enter a number...\n? ");$skip(20); 
  var x = readInt();System.out.println("""x  : Int = """ + $show(x ));$skip(107); 
  while (x != 0) {
    if (x > max)
      max = x
    print("enter a number...\n? ")
    x = readInt()
  };$skip(35); 
  println("The maximum is " + max)}
}