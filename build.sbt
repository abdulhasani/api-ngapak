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
  "org.springframework" % "spring-context" % "4.2.3.RELEASE",
  "org.springframework.data" % "spring-data-jpa" % "1.9.1.RELEASE",
  "org.springframework" % "spring-expression" % "4.2.3.RELEASE",
  "javax.inject" % "javax.inject" % "1",
  "org.mockito" % "mockito-core" % "1.9.5" % "test",
  "postgresql" % "postgresql" % "9.1-901-1.jdbc4",
  "net.sourceforge.javacsv" % "javacsv" % "2.0",
  "com.google.guava" % "guava" % "19.0"
)     

play.Project.playJavaSettings
