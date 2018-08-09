import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "ua.antoniuk"
version = "0.1-SNAPSHOT"

buildscript {
    @Suppress("ASSIGNED_BUT_NEVER_ACCESSED_VARIABLE")
    var kotlinVer: String by extra
    @Suppress("ASSIGNED_BUT_NEVER_ACCESSED_VARIABLE")
    var kotlinTestVer: String by extra
    @Suppress("ASSIGNED_BUT_NEVER_ACCESSED_VARIABLE")
    var mordrantVer: String by extra

    @Suppress("UNUSED_VALUE")
    kotlinVer = "1.2.10"
    @Suppress("UNUSED_VALUE")
    kotlinTestVer = "2.0.7"
    @Suppress("UNUSED_VALUE")
    mordrantVer = "1.1.0"
}

val kotlinVer: String by extra
val kotlinTestVer: String by extra
val mordrantVer: String by extra

repositories {
    jcenter()
}

plugins {
    kotlin("jvm") version "1.2.10"
    application
}

application {
    mainClassName = "ua.antoniuk.tetris.MainKt"
}

dependencies {
    implementation("com.github.ajalt:mordant:1.1.0")
    implementation("com.importre:crayon:0.1.0")
    compile(kotlin(module = "stdlib-jre8", version = kotlinVer))
    testCompile("io.kotlintest:kotlintest:$kotlinTestVer")
}

val compileKotlin by tasks.getting(KotlinCompile::class) {
    // Customise the “compileKotlin” task.
    kotlinOptions.jvmTarget = "1.8"
    doLast { println("Finished compiling Kotlin source code") }
}
val compileTestKotlin by tasks.getting(KotlinCompile::class) {
    // Customise the “compileTestKotlin” task.
    kotlinOptions.jvmTarget = "1.8"
    doLast { println("Finished compiling Kotlin source code for testing") }
}
