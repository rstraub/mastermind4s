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

  it should "return an error given invalid characters in secrets" in {
    val invalidInputs = Table(
      ("pegs", "error"),
      ("R,G,B,Y", Left("Invalid input: R,G,B,Y")),
      ("ABCD", Left("Invalid input: ABCD")),
      ("R G B Y", Left("Invalid input: R G B Y"))
    )

    forAll(invalidInputs) { (pegs, error) =>
      CodeParser parseCode pegs shouldBe error
    }
  }

  it should "return an error given secrets of not 4 characters long" in {
    val invalidInputs = Table(
      ("pegs", "error"),
      ("RGB", Left("Invalid input: RGB")),
      ("RGBYO", Left("Invalid input: RGBYO"))
    )

    forAll(invalidInputs) { (pegs, error) =>
      CodeParser parseCode pegs shouldBe error
    }
  }
}
