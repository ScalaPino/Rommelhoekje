package nl.scalapino

import swing._
import scala.swing.event.ButtonClicked

object HelloWorldGUI extends SimpleSwingApplication {
  val button = new Button { text = "Click Me!" }
  def top = new MainFrame {
    title = "Hello, world!"
    contents = button
    listenTo(button)
    reactions += {
      case ButtonClicked(button) =>
        println("Number of button clicks: ")
    }
  }
}
