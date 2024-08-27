// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    kotlin("jvm") version "1.9.24" // Kotlin version to use
}
version = "1.0-SNAPSHOT"

repositories {
    maven { url=uri ("https://jitpack.io") }
    maven { url=uri ("https://maven.aliyun.com/repository/releases") }
//        maven { url 'https://maven.aliyun.com/repository/jcenter' }
    maven { url=uri ("https://maven.aliyun.com/repository/google") }
    maven { url=uri ("https://maven.aliyun.com/repository/central") }
    maven { url=uri ("https://maven.aliyun.com/repository/gradle-plugin") }
    maven { url=uri ("https://maven.aliyun.com/repository/public") }
    google()
    mavenCentral()
    gradlePluginPortal()
    }
dependencies {
    repositories {
        maven { url=uri ("https://jitpack.io") }
        maven { url=uri ("https://maven.aliyun.com/repository/releases") }
//        maven { url 'https://maven.aliyun.com/repository/jcenter' }
        maven { url=uri ("https://maven.aliyun.com/repository/google") }
        maven { url=uri ("https://maven.aliyun.com/repository/central") }
        maven { url=uri ("https://maven.aliyun.com/repository/gradle-plugin") }
        maven { url=uri ("https://maven.aliyun.com/repository/public") }
        google()
        mavenCentral()
    }
}