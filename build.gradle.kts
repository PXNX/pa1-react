plugins {
    kotlin("js") version "1.5.30"
}

group = "nyx"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

tasks.create("stage") {
    dependsOn("browserProductionRun")
}


dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react:17.0.2-pre.244-kotlin-1.5.30")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom:17.0.2-pre.244-kotlin-1.5.30")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-router-dom:5.2.0-pre.206-kotlin-1.5.10")

    implementation("org.jetbrains.kotlin-wrappers:kotlin-styled:5.3.1-pre.244-kotlin-1.5.30")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-styled-next:0.1-pre.244-kotlin-1.5.30")

    implementation(npm("styled-components", "~5.2.1"))

}

kotlin {
    js(IR) {
        binaries.executable()
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
        }
    }
}

afterEvaluate {
    rootProject.extensions.configure<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension> {
        versions.webpackDevServer.version = "4.0.0"
    }
}