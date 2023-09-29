package nl.codecraftr.scala.kata

import cats.effect._
import cats.implicits._
import com.colofabrix.scala.figlet4s.catsio._

object Main extends IOApp {
  def run(args: List[String]): IO[ExitCode] = {
    val result =
      for {
        builder <- Figlet4s.builderF()
        figure <- builder.render("Mastermind4s")
        _ <- figure.print()
      } yield ExitCode.Success

    result.recover(handleError)
  }

  // Handle errors
  private def handleError: PartialFunction[Throwable, ExitCode] = {
    case error: Throwable =>
      println(s"Error while working with Figlet: $error")
      ExitCode.Error
  }
}
