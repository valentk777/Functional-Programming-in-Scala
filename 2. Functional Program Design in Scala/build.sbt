course := "progfun2"
assignment := "codecs"

scalaVersion := "2.13.4"

scalacOptions ++= Seq("-language:implicitConversions", "-deprecation")
libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % Test
libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.14.0"
libraryDependencies += "org.typelevel" %% "jawn-parser" % "0.14.2"
libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % Test


testOptions in Test += Tests.Argument(TestFrameworks.JUnit, "-a", "-v", "-s")
