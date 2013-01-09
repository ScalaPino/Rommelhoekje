object StarWars {

  class Ship(var health: Int = 0) {
    def hit = health -= 2
    def repaired(howGood: Int) { health += howGood }
  }

  trait Gun {
    def fireAt(s: Ship) = s.hit
  }

  trait Medic {
  }

  trait Shield {
    self: Ship =>
    override def hit = self.health -= 1
  }

  trait Repair {
    def repairTool(s: Ship, quality: Int) = s.repaired(quality)
  }

  val imperialFighter = new Ship(10) with Shield with Gun
                                                  //> imperialFighter  : StarWars.Ship with StarWars.Shield with StarWars.Gun = St
                                                  //| arWars$$anonfun$main$1$$anon$1@7eeb8007
  val imperialRepairShip = new Ship(10) with Repair with Medic
                                                  //> imperialRepairShip  : StarWars.Ship with StarWars.Repair with StarWars.Medic
                                                  //|  = StarWars$$anonfun$main$1$$anon$2@3810287d

  val rebelFighter = new Ship(10) with Shield with Gun
                                                  //> rebelFighter  : StarWars.Ship with StarWars.Shield with StarWars.Gun = StarW
                                                  //| ars$$anonfun$main$1$$anon$3@2cd2434c

  imperialFighter.fireAt(rebelFighter)
  println(rebelFighter.health)                    //> 9
}