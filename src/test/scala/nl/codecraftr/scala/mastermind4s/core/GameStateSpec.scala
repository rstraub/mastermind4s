package nl.codecraftr.scala.mastermind4s.core

import nl.codecraftr.scala.mastermind4s.core.GameState._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class GameStateSpec extends AnyFlatSpec with Matchers {
  "game state" should "start as 'setup'" in {
    GameState() shouldBe Setup
  }

  it should "transition from 'setup' to 'guessing'" in {
    Setup.transition shouldBe Guessing
  }

  it should "transition from 'guessing' to 'finished'" in {
    Guessing.transition shouldBe Finished
  }

//   TODO what do we do here?
  it should "transition from 'finished' to 'finished'" in {
//        GameState().transition shouldBe Finished
  }
}
