plugins {
    kotlin("jvm") version "1.5.0"
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

    // RxJava for Kotlin
    implementation("io.reactivex.rxjava3:rxkotlin:3.0.1")

    // JUnit 5 for testing
    testImplementation("org.junit.jupiter:junit-jupiter:5.7.0")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.7.0")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.7.0")

    // Mockito
    testImplementation("org.mockito:mockito-core:3.8.0")
    testImplementation("com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0")


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

