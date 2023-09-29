package nl.codecraftr.scala.mastermind4s.parsing

import nl.codecraftr.scala.mastermind4s.core
import nl.codecraftr.scala.mastermind4s.core.Color._
import nl.codecraftr.scala.mastermind4s.core.{Code, Color}

object CodeParser {
  def parseCode(input: String): Either[String, Code] = {
    if (!isValid(input)) return Left(s"Invalid input: $input")

    val colors = input.map(parseColor).toList
    Right(core.Code(colors.head, colors(1), colors(2), colors(3)))
  }

  private def isValid(input: String) = {
    "[RGBYOP]{4}".r.matches(input)
  }

  private def parseColor(c: Char): Color = c match {
    case 'R' => Red
    case 'G' => Green
    case 'B' => Blue
    case 'Y' => Yellow
    case 'O' => Orange
    case 'P' => Purple
  }
}
