package nl.codecraftr.scala.mastermind4s

import cats.effect._
import cats.effect.unsafe.implicits.global
import nl.codecraftr.scala.mastermind4s.Banner.banner
import nl.codecraftr.scala.mastermind4s.parsing.CodeParser

import scala.annotation.tailrec

object Main extends IOApp {
  override def run(args: List[String]): IO[ExitCode] = {
    val result = for {
      _ <- IO.println(banner)
      _ <- IO.println("Player 1 enter your code:")
      secret <- IO.readLine
      // TODO configure the game using the secret
      parsedSecret <- IO.fromEither(CodeParser parseCode secret)
      // TODO start the game, let the player guess the secret (10 times)
      _ <- IO(gameLoop)
    } yield parsedSecret

    result
      .onError { e: Throwable => IO.println(e.getMessage) }
      .recover(_ => ExitCode.Error)
      .map(_ => ExitCode.Success)
  }

  private def gameLoop = {
    @tailrec
    // TODO think of return type
    def go(attempts: Int = 10): IO[String] = {
      if (attempts == 0) IO("done")
      else {
        val result = for {
          _ <- IO.println(s"Attempts left $attempts")
          _ <- IO.println("Player 2 enter your guess:")
          guess <- IO.readLine

          // TODO: validate the guess
        } yield guess == "done"

        if (result.unsafeRunSync()) IO("done") else go(attempts - 1)
      }
    }

    go()
  }
}
