import play.Project._

name := "BelajarRestFulAPI"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaJpa.exclude("org.hibernate.javax.persistence", "hibernate-jpa-2.0-api"),
  "org.hibernate" % "hibernate-entitymanager" % "5.0.5.Final",
  "org.hibernate" % "hibernate-annotations" % "3.5.6-Final",
  "org.hibernate" % "hibernate-core" % "5.0.5.Final",
  "postgresql" % "postgresql" % "9.1-901-1.jdbc4",
  "net.sourceforge.javacsv" % "javacsv" % "2.0",
  "com.google.guava" % "guava" % "19.0"
)     

play.Project.playJavaSettings
