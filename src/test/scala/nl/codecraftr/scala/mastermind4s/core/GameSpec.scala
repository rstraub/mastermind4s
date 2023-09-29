package nl.codecraftr.scala.mastermind4s.core

import nl.codecraftr.scala.mastermind4s.core.Color._
import nl.codecraftr.scala.mastermind4s.core.GameState.Setup
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class GameSpec extends AnyFlatSpec with Matchers {
  "game" should "start by setting up the secret" in {
    Game().state shouldBe Setup
  }

  it should "return won when the secret is cracked" in {}

  it should "return lost when the secret is not cracked and there are no attempts left" in {}

  "storeSecret" should "store the secret given the game is in setup" in {
    Game().storeSecret(Code(Red, Green, Blue, Yellow)) shouldBe
      Game(secret = Some(Code(Red, Green, Blue, Yellow)))
  }
}
