package nl.codecraftr.scala.mastermind4s.core

import nl.codecraftr.scala.mastermind4s.core.GameState.Setup

case class Game(
    attempts: Int = 10,
    state: GameState = Setup,
    secret: Option[Code] = None
) {
  def storeSecret(secret: Code): Game = Game(secret = Some(secret))
}
