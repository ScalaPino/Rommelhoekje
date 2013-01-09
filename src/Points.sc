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
  }

  var p = new Point(3, 2) //> p  : Testje.Point = (3,2)
  println(p) //> (3,2)
  var q = new Point3D(4, 5, 6) //> q  : Testje.Point3D = (4,5,6)
  p = q
  println(p) //> (4,5,6)
  q.translate(1, 1, 1)
  println(p) //> (5,6,7)
  p.translate(1, 1)
  println(p) //> (6,7,7)
}