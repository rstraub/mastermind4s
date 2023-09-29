package nl.codecraftr.scala.mastermind4s

import cats.effect._
import cats.effect.std.Console
import cats.effect.unsafe.implicits.global
import nl.codecraftr.scala.mastermind4s.parsing.CodeParser

import scala.annotation.tailrec

object Main extends IOApp {

  override def run(args: List[String]): IO[ExitCode] = {
    for {
      _ <- Console[IO].println("Mastermind4s")
      _ <- Console[IO].println("============")
      _ <- Console[IO].println("Player 1 enter your code:")
      secret <- Console[IO].readLine
      // TODO configure the game using the secret
      parsedSecret <- IO(CodeParser parseCode secret)
      _ <- IO(gameLoop)
      // TODO start the game, let the player guess the secret (10 times)
    } yield ExitCode.Success

    // TODO show something to user in case of error
  }

  private def gameLoop = {
    @tailrec
    // TODO think of return type
    def go(attempts: Int = 10): IO[String] = {
      if (attempts == 0) IO("done")
      else {
        val result = for {
          _ <- Console[IO].println(s"Attempts left $attempts")
          _ <- Console[IO].println("Player 2 enter your guess:")
          guess <- Console[IO].readLine
          // TODO: validate the guess
        } yield (guess == "done")

        if (result.unsafeRunSync()) IO("done") else go(attempts - 1)
      }
    }

    go()
  }
}
