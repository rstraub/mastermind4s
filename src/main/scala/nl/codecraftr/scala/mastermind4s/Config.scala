package nl.codecraftr.scala.mastermind4s

import pureconfig._
import pureconfig.generic.auto._

case class Banner(value: String) extends AnyVal

case class AppConf(
    banner: Banner
)
