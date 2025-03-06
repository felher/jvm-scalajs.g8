import org.scalajs.linker.interface.ModuleSplitStyle

val scala3Version = "3.6.3"

lazy val root = project
  .in(file("."))
  .aggregate($name;format="lower"$.js, $name;format="lower"$.jvm)
  .settings(
    publish := {},
    publishLocal := {},
  )

lazy val $name;format="lower"$ = crossProject(JSPlatform, JVMPlatform)
  .in(file("."))
  .settings(
    name := "$name$",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,
    scalacOptions ++= Seq(
      "-language:strictEquality",
      "-source:future",
      "-feature",
      "-deprecation",
      "-Xkind-projector:underscores",
      "-Xmax-inlines:256",
      "-Wall"
    )
  ).jsSettings(
    scalaJSUseMainModuleInitializer := true,
    scalaJSLinkerConfig ~= {
      _.withModuleKind(ModuleKind.ESModule)
        .withModuleSplitStyle(ModuleSplitStyle.SmallModulesFor(List("$organization$.$name;format="lower"$")))
    },
    libraryDependencies ++= Seq(
      "org.scala-js" %%% "scalajs-dom" % "2.8.0",
      "com.raquo"    %%% "laminar"     % "17.2.0",
      "org.felher"   %%% "beminar"     % "1.1.0"
    )
  )
