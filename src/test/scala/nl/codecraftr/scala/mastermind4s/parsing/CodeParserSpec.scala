package nl.codecraftr.scala.mastermind4s.parsing

import nl.codecraftr.scala.mastermind4s.core.Code
import nl.codecraftr.scala.mastermind4s.core.Color._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.TableDrivenPropertyChecks

class CodeParserSpec
    extends AnyFlatSpec
    with Matchers
    with TableDrivenPropertyChecks {

  "parse" should "return a code given a secret with 4 of the 6 colors" in {
    val validInputs = Table(
      ("pegs", "code"),
      ("RGBY", Right(Code(Red, Green, Blue, Yellow))),
      ("RGPO", Right(Code(Red, Green, Purple, Orange)))
    )

    forAll(validInputs) { (pegs, code) =>
      CodeParser parseCode pegs shouldBe code
    }
  }

  // TODO: Add error types
  // TODO: Return errors per input violation (code length, code characters)
  it should "return an error given invalid characters in secrets" in {
    val invalidInputs = Table(
      ("pegs"),
      ("R,G,B,Y"),
      ("ABCD"),
      ("R G B Y")
    )

    forAll(invalidInputs) { pegs =>
      CodeParser.parseCode(pegs).isLeft shouldBe true
    }
  }

  it should "return an error given secrets of not 4 characters long" in {
    val invalidInputs = Table(
      ("pegs"),
      ("RGB"),
      ("RGBYO")
    )

    forAll(invalidInputs) { pegs =>
      CodeParser.parseCode(pegs).isLeft shouldBe true
    }
  }
}
