val scala3Version = "3.3.1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "scribe",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies += "org.scalameta" %% "munit" % "0.7.29" % Test,
    libraryDependencies += "com.github.nscala-time" %% "nscala-time" % "2.32.0",
    libraryDependencies += "org.openjfx" % "javafx-controls" % "17.0.1"
  )