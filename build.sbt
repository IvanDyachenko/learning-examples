// scalafmt: { align.tokens.add = [ {code = ":=", owner = "Term.ApplyInfix"}, {code = "at", owner = "Term.ApplyInfix"} ] }

ThisBuild / name         := "concurrency-examples"
ThisBuild / version      := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.11.12"

fork := false

scalafmtOnCompile := true

resolvers ++= Seq(
  "Sonatype OSS Releases"  at "https://oss.sonatype.org/content/repositories/releases",
  "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
  ("Typesafe Repository"   at "http://repo.typesafe.com/typesafe/releases/").withAllowInsecureProtocol(true)
)

libraryDependencies ++= List(
  "org.scala-stm"          %% "scala-stm"                % "0.11.1",
  "org.scala-lang.modules" %% "scala-async"              % "0.9.7",
  "org.scala-lang.modules" %% "scala-swing"              % "3.0.0",
  "org.scalaz"             %% "scalaz-concurrent"        % "7.2.32",
  "org.scalafx"            %% "scalafx"                  % "15.0.1-R21",
  "com.storm-enroute"      %% "scalameter-core"          % "0.19",
  "com.storm-enroute"      %% "reactive-collections"     % "0.5",
  "com.typesafe.akka"      %% "akka-actor"               % "2.3.2",
  "com.typesafe.akka"      %% "akka-remote"              % "2.3.2",
  "com.typesafe.akka"      %% "akka-stream-experimental" % "0.4",
  "com.quantifind"         %% "wisp"                     % "0.0.4",
  "com.github.scala-blitz" %% "scala-blitz"              % "1.2",
  "com.netflix.rxjava"      % "rxjava-scala"             % "0.20.7",
  "commons-io"              % "commons-io"               % "2.10.0",
)
