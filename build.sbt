import sbt.Keys.libraryDependencies

ThisBuild / scalaVersion     := "2.13.1"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "hello-ebean",
    libraryDependencies += "io.ebean" % "ebean" % "12.2.4",
    libraryDependencies += "io.ebean" % "ebean-querybean" % "12.2.4",
    libraryDependencies += "org.scalactic" %% "scalactic" % "3.1.1",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.1" % "test",
    libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.44",
    libraryDependencies += "com.typesafe" % "config" % "1.4.0",
    libraryDependencies += "org.reflections" % "reflections" % "0.9.12",
    libraryDependencies += "org.slf4j" % "slf4j-simple" % "1.7.30",
      libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3",
      libraryDependencies += "junit" % "junit" % "4.13" % Test,
    libraryDependencies += "io.ebean" % "ebean-test" % "12.2.3" % Test,
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
