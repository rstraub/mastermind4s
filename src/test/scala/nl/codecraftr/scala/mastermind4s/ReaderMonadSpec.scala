package nl.codecraftr.scala.mastermind4s

import cats.data.Reader
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ReaderMonadSpec extends AnyFlatSpec with Matchers {
  type NameReader[A] = Reader[NameConfig, A]
  case class NameConfig(name: String)
  object Greeter {
    def shouting: NameReader[String] = Reader { config =>
      config.name.toUpperCase
    }

    def angry: NameReader[String] = Reader { config =>
      s"${config.name}!!!"
    }

    def greet: NameReader[String] = Reader { config =>
      s"Hello ${config.name}"
    }
  }

  it should "allow greeting" in {
    val result = Greeter.greet.run(NameConfig("John"))

    result shouldBe "Hello John"
  }

  it should "allow composition" in {
    val chain = for {
      g <- Greeter.greet
      a <- Greeter.angry
      s <- Greeter.shouting
    } yield (g, a, s)

    val result = chain.run(NameConfig("John"))

    result._1 shouldBe "Hello John"
    result._2 shouldBe "John!!!"
    result._3 shouldBe "JOHN"
  }
}
