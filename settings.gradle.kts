rootProject.name = "gradleIssue"
include("lib")

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            val kotlin = version("kotlin", "1.6.21")
            val junit = version("junit", "5.8.2")
            library("kotlin-stdlib", "org.jetbrains.kotlin", "kotlin-stdlib-jdk8").versionRef(kotlin)
            library("junit-jupiter", "org.junit.jupiter", "junit-jupiter").versionRef(junit)
            plugin("kotlin-jvm", "org.jetbrains.kotlin.jvm").versionRef(kotlin)
            plugin("dokka", "org.jetbrains.dokka").versionRef(kotlin)
            plugin("m-versions", "com.github.ben-manes.versions").version("0.42.0")
        }
    }
}
