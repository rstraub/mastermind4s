package nl.codecraftr.scala.mastermind4s

import cats.data.Writer
import cats.implicits._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class WriterMonadSpec extends AnyFlatSpec with Matchers {
  type LogWriter[A] = Writer[Vector[String], A]

  private def exampleApp: LogWriter[Int] = {
    for {
      a <- 10.pure[LogWriter]
      _ <- Vector("log 1").tell
      b <- 32 writer Vector("log 2")
    } yield a + b
  }

  it should "be used to write logs and return a result" in {
    val (log, result) = exampleApp.run

    result shouldBe 42
    log.mkString(", ") shouldBe "log 1, log 2"
  }
}
