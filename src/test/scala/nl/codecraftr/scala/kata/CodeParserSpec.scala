package nl.codecraftr.scala.kata

import nl.codecraftr.scala.kata.Main.Code
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.TableDrivenPropertyChecks
import nl.codecraftr.scala.kata.Color._

class CodeParserSpec
    extends AnyFlatSpec
    with Matchers
    with TableDrivenPropertyChecks {

  "parse" should "return a Code given a valid secret" in {
    val validInputs = Table(
      ("pegs", "code"),
      ("RGBY", Code(Red, Green, Blue, Yellow)),
      ("RGPO", Code(Red, Green, Purple, Orange))
    )

    forAll(validInputs) { (pegs, code) =>
      Main parseCode pegs shouldBe code
    }
  }

  it should "handle invalid secrets" in {
    pending
  }
}
