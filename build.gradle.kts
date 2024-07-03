plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
    kotlin("plugin.compose")

    id("convention.publication")
}

group = "io.github.kirillNay"
version = "1.1.0"

repositories {
    mavenCentral()
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

kotlin {
    js(IR) {
        moduleName = "mini-app"
        binaries.executable()
        browser()
    }
    sourceSets {
        jsMain.dependencies {
            api(compose.runtime)
            api(compose.foundation)
            api(compose.ui)
        }
    }
}