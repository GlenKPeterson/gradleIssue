import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val versionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")
println("Library aliases: ${versionCatalog.libraryAliases}")

plugins {
    `java-library`

    alias(libs.m.versions)
    alias(libs.kotlin.dokka)
    alias(libs.kotlin.jvm)
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    implementation(libs.kotlin.stdlib)
    testImplementation(libs.junit.jupiter)
}
