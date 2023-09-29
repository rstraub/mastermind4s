package nl.codecraftr.scala.kata

import com.colofabrix.scala.figlet4s.unsafe._

object Main extends App {
  private val builder = Figlet4s.builder()
  private val figure = builder.render("Mastermind4s")

  figure.print()
}
