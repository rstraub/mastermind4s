package nl.codecraftr.scala.mastermind4s

import cats.effect._
import cats.effect.std.Console
import nl.codecraftr.scala.mastermind4s.parsing.CodeParser

object Main extends IOApp {

  override def run(args: List[String]): IO[ExitCode] = {
    for {
      _ <- Console[IO].println("Mastermind4s")
      _ <- Console[IO].println("============")
      _ <- Console[IO].println("Player 1 enter your code:")
      secret <- Console[IO].readLine
      _ <- IO(CodeParser parseCode secret)
    } yield ExitCode.Success
  }
}
