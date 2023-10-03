package nl.codecraftr.scala.mastermind4s

import cats.effect._
import cats.effect.std.Console
import nl.codecraftr.scala.mastermind4s.Banner.banner
import nl.codecraftr.scala.mastermind4s.parsing.CodeParser

object Main extends IOApp {
  override def run(args: List[String]): IO[ExitCode] = {
    val result = for {
      _ <- IO.println(banner)
      _ <- IO.println("Player 1 enter your code:")
      secret <- IO.readLine
      // TODO configure the game using the secret
      parsedSecret <- IO.fromEither(CodeParser parseCode secret)
      // TODO start the game, let the player guess the secret (10 times)
      loop <- gameLoop
    } yield (parsedSecret, loop)

    result
      .map(_ => ExitCode.Success)
      .handleErrorWith { t =>
        Console[IO]
          .errorln(s"Something went wrong: ${t.getMessage}")
          .as(ExitCode.Error)
      }
  }

  private def gameLoop = {
    // TODO think of return type
    def go(attempts: Int = 10): IO[String] = {
      if (attempts == 0) IO("done")
      else {
        for {
          _ <- IO.println(s"Attempts left $attempts")
          _ <- IO.println("Player 2 enter your guess:")
          guess <- IO.readLine
          result <- if (guess == "done") IO("done") else go(attempts - 1)
          // TODO: validate the guess
        } yield result
      }
    }

    go()
  }
}
