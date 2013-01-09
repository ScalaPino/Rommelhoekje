class Cell {
  var contents: Int = 0
  def get() = contents
  def set(n: Int) = {
    contents = n
  }
}

class reCell(x :Int) extends newCell(x) {
  protected var backup: Int = 0
  override def set(n: Int) = {
    backup = this.contents
    super.set(n) //this.contents = n
  }
  def restore() = contents = backup
}

class newCell(protected var contents: Int) {
  def this() = this(0)
  def get() = contents
  def set(n: Int) = {
    contents = n
  }
}

object Cell {
  import Cell._;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(511); 
  val a = new reCell(0);System.out.println("""a  : reCell = """ + $show(a ))}
}