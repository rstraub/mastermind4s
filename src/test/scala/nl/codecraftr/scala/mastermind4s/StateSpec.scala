package nl.codecraftr.scala.mastermind4s

import cats.data.State
import State._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class StateSpec extends AnyFlatSpec with Matchers {
  private val inc = State[Int, String] { num =>
    val updated = num + 1
    (updated, s"number is now $updated")
  }

  it should "propagate state" in {
    val result = for {
      _ <- modify[Int](_ + 1)
      _ <- modify[Int](_ + 2)
      _ <- inc
      c <- inspect[Int, String](n => s"final number is $n")
    } yield c

    result.run(0).value shouldBe (4, "final number is 4")
  }
}
