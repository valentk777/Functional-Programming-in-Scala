name := "Functional-Program-Design-in-Scala"
version := "0.1"
scalaVersion := "2.13.4"

course := "progfun2"
assignment := "quickcheck"

scalacOptions ++= Seq("-language:implicitConversions", "-deprecation")

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % "test"
libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % Test
libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.14.1" % "test"

testOptions in Test += Tests.Argument(TestFrameworks.JUnit, "-a", "-v", "-s")
