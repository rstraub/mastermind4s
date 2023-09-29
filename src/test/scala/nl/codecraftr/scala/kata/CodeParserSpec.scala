package nl.codecraftr.scala.kata

import nl.codecraftr.scala.kata.Main.Code
import nl.codecraftr.scala.kata.Main.Color._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.TableDrivenPropertyChecks

class CodeParserSpec
    extends AnyFlatSpec
    with Matchers
    with TableDrivenPropertyChecks {

  "parse" should "return a Code given a valid secret" in {
    val validInputs = Table(
      ("pegs", "code"),
      ("R,G,B,Y", Code(Red, Green, Blue, Yellow)),
      ("R,G,P,O", Code(Red, Green, Purple, Orange))
    )

    forAll(validInputs) { (pegs, code) =>
      Main parseSecret pegs shouldBe code
    }
  }
}
