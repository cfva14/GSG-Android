plugins {
    id 'org.jetbrains.kotlin.jvm' version "1.4.0"
    id 'application'
}
group = 'com.test'
version = '1.0-SNAPSHOT'

repositories {
    mavenCentral()
    jcenter()
}

javafx {
    version = "11.0.2"
    modules = ['javafx.controls', 'javafx.fxml']
}

application {
    mainClassName = "edu.ucsf.MainKt"
}

dependencies {
    implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk8"
    implementation "no.tornado:tornadofx:$tornadofx_version"
    testImplementation "org.jetbrains.kotlin:kotlin-test-junit"
}

compileKotlin {
    kotlinOptions.jvmTarget = "11"
}
compileTestKotlin {
    kotlinOptions.jvmTarget = "11"
}