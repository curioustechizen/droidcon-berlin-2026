plugins {
    id("org.jetbrains.kotlin.jvm") version "2.4.20"
    application
    alias(libs.plugins.wire)
}

dependencies {
}

application {
    mainClass = "kiranrao.app.AppKt"
}

wire {
 kotlin {}
}