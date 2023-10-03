import sbt._

object Dependencies {
  // Testing
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.2.17" % Test
  lazy val scalaCheck =
    "org.scalatestplus" %% "scalacheck-1-17" % "3.2.17.0" % Test
  lazy val mockito = "org.scalatestplus" %% "mockito-4-11" % "3.2.17.0" % Test

  // Cats
  lazy val catsCore = "org.typelevel" %% "cats-core" % "2.10.0"
  lazy val catsEffects = "org.typelevel" %% "cats-effect" % "3.5.2"

  // Logging
  lazy val logging = "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5"
  lazy val logback = "ch.qos.logback" % "logback-classic" % "1.4.7"

  // Config
  lazy val pureConfig = "com.github.pureconfig" %% "pureconfig" % "0.17.4"
}
