package nl.codecraftr.scala.mastermind4s

import cats.effect._
import cats.effect.std.Console
import nl.codecraftr.scala.mastermind4s.core.{Code, Color}
import nl.codecraftr.scala.mastermind4s.core.Color._

object Main extends IOApp {

  override def run(args: List[String]): IO[ExitCode] = {
    for {
      _ <- Console[IO].println("Mastermind4s")
      _ <- Console[IO].println("============")
      _ <- Console[IO].println("Player 1 enter your code:")
      secret <- Console[IO].readLine
      _ <- IO(parseCode(secret))
    } yield ExitCode.Success
  }

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
