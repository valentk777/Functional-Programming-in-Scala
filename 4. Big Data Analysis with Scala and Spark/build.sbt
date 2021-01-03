name := "Big-Data-Analysis-with-Scala-and-Spark"
version := "0.1"
scalaVersion := "2.13.4"

course := "progfun1"
assignment := "example"

scalacOptions ++= Seq("-language:implicitConversions", "-deprecation")

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % "test"
libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % Test

testOptions in Test += Tests.Argument(TestFrameworks.JUnit, "-a", "-v", "-s")
