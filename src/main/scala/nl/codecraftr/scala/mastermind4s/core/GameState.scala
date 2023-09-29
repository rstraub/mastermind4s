package nl.codecraftr.scala.mastermind4s.core

sealed trait GameState {
  def transition: GameState
}

object GameState {
  def apply(): GameState = Setup

  case object Setup extends GameState {
    override def transition: GameState = Guessing
  }

  case object Guessing extends GameState {
    override def transition: GameState = Finished
  }

  case object Finished extends GameState {
    override def transition: GameState = ???
  }
}
