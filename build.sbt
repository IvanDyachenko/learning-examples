// scalafmt: { align.tokens.add = [ {code = ":=", owner = "Term.ApplyInfix"}, {code = "at", owner = "Term.ApplyInfix"} ] }

ThisBuild / name         := "concurrency-examples"
ThisBuild / version      := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.11.1"

fork := false

scalafmtOnCompile := true

resolvers ++= Seq(
  "Sonatype OSS Releases"  at "https://oss.sonatype.org/content/repositories/releases",
  "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
  ("Typesafe Repository"   at "http://repo.typesafe.com/typesafe/releases/").withAllowInsecureProtocol(true)
)

libraryDependencies ++= List(
  "org.scala-stm"          %% "scala-stm"                % "0.7",
  "org.scala-lang.modules" %% "scala-async"              % "0.9.1",
  "org.scala-lang.modules" %% "scala-swing"              % "1.0.1",
  "org.scalaz"             %% "scalaz-concurrent"        % "7.0.6",
  "org.scalafx"            %% "scalafx"                  % "1.0.0-R8",
  "com.storm-enroute"      %% "scalameter-core"          % "0.6",
  "com.storm-enroute"      %% "reactive-collections"     % "0.5",
  "com.typesafe.akka"      %% "akka-actor"               % "2.3.2",
  "com.typesafe.akka"      %% "akka-remote"              % "2.3.2",
  "com.typesafe.akka"      %% "akka-stream-experimental" % "0.4",
  "com.quantifind"         %% "wisp"                     % "0.0.4",
  "com.github.scala-blitz" %% "scala-blitz"              % "1.2",
  "com.netflix.rxjava"      % "rxjava-scala"             % "0.19.1",
  "commons-io"              % "commons-io"               % "2.6",
)

Compile / unmanagedJars += Attributed.blank(file(scala.util.Properties.javaHome) / "/lib/jfxrt.jar")
