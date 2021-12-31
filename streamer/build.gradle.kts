import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.10"
    id("com.google.cloud.tools.jib") version "3.1.4"
    application
}
buildscript {
    repositories {
        mavenCentral()
        maven("https://packages.confluent.io/maven")
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
        classpath("com.commercehub.gradle.plugin:gradle-avro-plugin:0.22.0")
        classpath("com.github.jengelman.gradle.plugins:shadow:4.0.2")
    }
}
group = "com.devmarkpro.transformer"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://packages.confluent.io/maven")
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("io.confluent:kafka-streams-avro-serde:6.2.1")
    implementation("org.apache.kafka:kafka-streams:2.8.1")
    implementation("org.apache.avro:avro:1.10.2")
    implementation("org.slf4j:slf4j-simple:1.7.30")
//    testImplementation(kotlin("org.junit.jupiter:junit-jupiter-api:5.8.1"))
//    testImplementation(kotlin("org.junit.jupiter:junit-jupiter-engine:5.8.1"))
    testImplementation(kotlin("test"))
}


tasks.test {
    useJUnitPlatform()
}
//
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

application {
    mainClass.set("MainKt")
}
