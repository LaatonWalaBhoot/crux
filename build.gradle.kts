import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm").version("1.6.20")
}

repositories {
  mavenCentral()
}

buildscript {
  extra["kotlinVersion"] = "1.6.20"
  repositories {
    mavenCentral()
  }
  dependencies {
    classpath(kotlin("gradle-plugin", version = rootProject.extra["kotlinVersion"] as String?))
  }
}

dependencies {
  api("org.jsoup:jsoup:1.13.1")
  api("com.squareup.okhttp3:okhttp:4.9.0")
  implementation("org.apache.commons:commons-text:1.9")
  testImplementation("junit:junit:4.13")
}

configurations.all {
  // Re-run tests every time test cases are updated, even if sources haven’t been updated.
  resolutionStrategy.cacheChangingModulesFor(0, "seconds")
}

tasks.withType<KotlinCompile>().configureEach {
  kotlinOptions {
    allWarningsAsErrors = true
  }
}
