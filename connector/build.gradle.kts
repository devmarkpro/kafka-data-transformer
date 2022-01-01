plugins {
    kotlin("jvm") version "1.6.10"
}

group = "com.devmarkpro.connector"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.exposed", "exposed-core", "0.37.3")
    implementation("org.jetbrains.exposed", "exposed-dao", "0.37.3")
    implementation("org.jetbrains.exposed", "exposed-jdbc", "0.37.3")
    implementation("org.postgresql:postgresql:42.2.2")
    implementation("io.github.serpro69:kotlin-faker:1.9.0")
}
