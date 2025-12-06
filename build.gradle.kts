plugins {
    alias(libs.plugins.kotlin.jvm)
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.aoc)
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useKotlinTest("2.2.20")
        }
    }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    mainClass = "RunnerKt"
}

tasks {
    val mainRuntimeClasspath = sourceSets["main"].runtimeClasspath
    (1..12).forEach { i ->
        val day = "%02d".format(i)
        register<JavaExec>("runDay$day") {
            group = "advent"
            description = "Run Advent of Code Day $day"
            mainClass.set("RunnerKt")
            args = listOf(day)
            classpath = mainRuntimeClasspath
        }
    }
}
