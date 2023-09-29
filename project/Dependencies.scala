import sbt._

object Dependencies {
  private val figlet4sVersion = "0.3.2"

  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.2.17" % Test
  lazy val scalaCheck =
    "org.scalatestplus" %% "scalacheck-1-17" % "3.2.17.0" % Test
  lazy val mockito = "org.scalatestplus" %% "mockito-4-11" % "3.2.17.0" % Test
  lazy val catsCore = "org.typelevel" %% "cats-core" % "2.10.0"
  lazy val figlet4sCore =
    "com.colofabrix.scala" %% "figlet4s-core" % figlet4sVersion
  lazy val figlet4sEffects =
    "com.colofabrix.scala" %% "figlet4s-effects" % figlet4sVersion
}
