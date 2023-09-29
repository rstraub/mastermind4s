package nl.codecraftr.scala.kata

import cats.effect._
import cats.effect.std.Console
import nl.codecraftr.scala.kata.Color._

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
    val isValid = "[RGBYOP]{4}".r.matches(input)
    if (!isValid) return Left(s"Invalid input: $input")

    val colors = input.map(parseColor).toList
    Right(Code(colors.head, colors(1), colors(2), colors(3)))
  }

  private def parseColor(c: Char): Color = c match {
    case 'R' => Red
    case 'G' => Green
    case 'B' => Blue
    case 'Y' => Yellow
    case 'O' => Orange
    case 'P' => Purple
  }

  case class Code(peg1: Color, peg2: Color, peg3: Color, peg4: Color)

}
