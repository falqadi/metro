plugins {
  java
  application
}

repositories { mavenCentral() }

val daggerVersion = "2.60.1"

dependencies {
  implementation("com.google.dagger:dagger:$daggerVersion")
  annotationProcessor("com.google.dagger:dagger-compiler:$daggerVersion")
}

tasks.withType<JavaCompile> {
  options.release = 17
  // Dagger's fast init mode, the counterpart of Metro's switching providers.
  options.compilerArgs.add("-Adagger.fastInit=enabled")
}

application { mainClass = "repro.Main" }
