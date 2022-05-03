//val versionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")
//println("Library aliases: ${versionCatalog.libraryAliases}")

plugins {
    `java-library`

    @Suppress("DSL_SCOPE_VIOLATION")
    alias(libs.plugins.m.versions)
    @Suppress("DSL_SCOPE_VIOLATION")
    alias(libs.plugins.dokka)
    @Suppress("DSL_SCOPE_VIOLATION")
    alias(libs.plugins.kotlin.jvm)
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    implementation(libs.kotlin.stdlib)
    testImplementation(libs.junit.jupiter)
}
