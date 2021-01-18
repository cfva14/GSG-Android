plugins {
    kotlin("jvm") version "1.4.0"
    application
    id("org.openjfx.javafxplugin") version "0.0.9"
}

application { mainClassName = "edu.ucsf.MainKt" }

repositories {
    mavenCentral()
    jcenter()
    maven("https://plugins.gradle.org/m2/")
    maven("https://dl.bintray.com/kotlin/kotlin-eap")
}

dependencies {
    // Kotlin standard library
    implementation(kotlin("stdlib-jdk8"))

    // TornadoFX dependency
    implementation("no.tornado:tornadofx:1.7.20")

    // JUnit 5 for testing
    testImplementation("org.junit.jupiter:junit-jupiter:5.7.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.0")
}

// JavaFX module to include
javafx { modules("javafx.controls", "javafx.fxml", "javafx.graphics") }

// Set Kotlin/JVM target versions
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
    kotlinOptions.languageVersion = "1.4"
}

// Use JUnit
tasks.test { useJUnitPlatform() }

// Be sure to use latest Gradle version
tasks.named<Wrapper>("wrapper") { gradleVersion = "6.7.1" }

