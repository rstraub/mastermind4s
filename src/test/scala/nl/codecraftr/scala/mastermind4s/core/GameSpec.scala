package nl.codecraftr.scala.mastermind4s.core

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class GameSpec extends AnyFlatSpec with Matchers {
  "game" should "return playing when the secret is not cracked and there are attempts left" in {}

  it should "return won when the secret is cracked" in {}

  it should "return lost when the secret is not cracked and there are no attempts left" in {}
}
