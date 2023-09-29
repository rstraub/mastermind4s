package nl.codecraftr.scala.kata

import cats.effect._
import cats.effect.std.Console

object Main extends IOApp {

  override def run(args: List[String]): IO[ExitCode] = {
    for {
      _ <- Console[IO].println("Mastermind4s")
      _ <- Console[IO].println("============")
      _ <- Console[IO].println("Player 1 enter your code:")
      secret <- Console[IO].readLine

      _ <- Console[IO].println(s"$secret")

    } yield ExitCode.Success
  }
}
