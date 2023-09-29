package nl.codecraftr.scala.mastermind4s

import nl.codecraftr.scala.mastermind4s.core.Code
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.TableDrivenPropertyChecks
import nl.codecraftr.scala.mastermind4s.core.Color._

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
      Main parseCode pegs shouldBe code
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
      Main parseCode pegs shouldBe error
    }
  }

  it should "return an error given secrets of not 4 characters long" in {
    val invalidInputs = Table(
      ("pegs", "error"),
      ("RGB", Left("Invalid input: RGB")),
      ("RGBYO", Left("Invalid input: RGBYO"))
    )

    forAll(invalidInputs) { (pegs, error) =>
      Main parseCode pegs shouldBe error
    }
  }
}
