object Points {
  class Point(var x: Int, var y: Int) {
    def this() = this(0, 0)
    def move(x1: Int, y1: Int) = { x = x1; y = y1 }
    def translate(dx: Int, dy: Int) = {
      x += dx; y += dy;
    }
    override def toString = "(" + x + "," + y + ")"
  }

  class Point3D(x2d: Int, y2d: Int, var z: Int)
    extends Point(x2d, y2d) {
    def move(new_x: Int, new_y: Int, new_z: Int) = {
      x = new_x; y = new_y; z = new_z;
    }
    def translate(dx: Int, dy: Int, dz: Int) = {
      x += dx; y += dy; z += dz;
    }
    override def toString = "(" + x + "," + y + "," + z + ")"
  };import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(621); 

  var p = new Point(3, 2);System.out.println("""p  : Points.Point = """ + $show(p ));$skip(13); 
  println(p);$skip(31); 
  var q = new Point3D(4, 5, 6);System.out.println("""q  : Points.Point3D = """ + $show(q ));$skip(8); 
  p = q;$skip(13); 
  println(p);$skip(23); 
  q.translate(1, 1, 1);$skip(13); 
  println(p);$skip(20); 
  p.translate(1, 1);$skip(13); 
  println(p)}
}
