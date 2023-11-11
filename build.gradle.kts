plugins {
  kotlin("jvm") version "1.9.20"
}

group = "ca.cutterslade"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
  testImplementation("io.kotest:kotest-framework-api:5.7.2")
  testRuntimeOnly("io.kotest:kotest-runner-junit5:5.7.2")
}

tasks.test {
  useJUnitPlatform { includeEngines("kotest") }
}

kotlin {
  jvmToolchain(17)
}
