package nl.codecraftr.scala.kata

import cats.effect._
import cats.effect.std.Console
import nl.codecraftr.scala.kata.Main.Color.{Blue, Green, Red, Yellow}

object Main extends IOApp {

  override def run(args: List[String]): IO[ExitCode] = {
    for {
      _ <- Console[IO].println("Mastermind4s")
      _ <- Console[IO].println("============")
      _ <- Console[IO].println("Player 1 enter your code:")
      secret <- Console[IO].readLine
      _ <- IO(parseSecret(secret))
    } yield ExitCode.Success
  }

  def parseSecret(str: String): Code = Code(Red, Green, Blue, Yellow)

  case class Code(peg1: Color, peg2: Color, peg3: Color, peg4: Color)

  sealed trait Color
  object Color {
    case object Red extends Color
    case object Green extends Color
    case object Blue extends Color
    case object Yellow extends Color
    case object Orange extends Color
    case object Purple extends Color
  }
}
