plugins {
    kotlin("jvm") version "1.4.0"
    application
    id("org.openjfx.javafxplugin") version "0.0.9"
}

application { mainClassName = "org.b12x.gfe.MainKt" }

repositories {
    mavenCentral()
    jcenter()
    maven("https://plugins.gradle.org/m2/")
    maven("https://dl.bintray.com/kotlin/kotlin-eap")
}

dependencies {
    // Kotlin standard library
    implementation(kotlin("stdlib-jdk8"))
    implementation( "org.jetbrains.kotlin:kotlin-reflect:1.4.30")

    // TornadoFX dependency
    implementation("no.tornado:tornadofx:1.7.20")

    // API tools
    implementation("com.squareup.okhttp3:okhttp:4.2.1")
    implementation("com.squareup.okio:okio:2.10.0")

    // JSON parsing
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.12.3")

    // JUnit 5 for testing
    testImplementation("org.junit.jupiter:junit-jupiter:5.7.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.0")

    // Mockito
//    testImplementation("io.mockk:mockk:1.10.6")
//    testImplementation("org.mockito:mockito-kotlin:2.2.0")
    testImplementation("com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0")
    testImplementation("com.squareup.okhttp3:mockwebserver:4.9.0")
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

