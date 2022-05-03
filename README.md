# Gradle Issue

This is my current trouble using Gradle.
It is not a bug in Gradle.
I'm kind of a Gradle noob.

```shell
$ gradle tasks
To honour the JVM settings for this build a single-use Daemon process will be forked. See https://docs.gradle.org/7.4.1/userguide/gradle_daemon.html#sec:disabling_the_daemon.
Daemon will be stopped at the end of the build

> Configure project :lib
e: /tools/gradleIssue/lib/build.gradle.kts:9:16: Unresolved reference: m
e: /tools/gradleIssue/lib/build.gradle.kts:10:23: Unresolved reference: dokka
e: /tools/gradleIssue/lib/build.gradle.kts:11:23: Unresolved reference: jvm

FAILURE: Build failed with an exception.

* Where:
Build file '/tools/gradleIssue/lib/build.gradle.kts' line: 9

* What went wrong:
Script compilation errors:

  Line 09:     alias(libs.m.versions)
                          ^ Unresolved reference: m

  Line 10:     alias(libs.kotlin.dokka)
                                 ^ Unresolved reference: dokka

  Line 11:     alias(libs.kotlin.jvm)
                                 ^ Unresolved reference: jvm

3 errors
...
```

## Fixed!

Thanks to the [Gradle Community Slack](https://discuss.gradle.org/t/introducing-gradle-community-slack/26731)
for the solution!

### Vampire  29 minutes ago
Not sure how your MCVE is related to your question. The error you show in the readme is because you didn't do `libs.plugins.dokka` and so on, but `libs.kotlin.dokka`.

🙌🏻 1  🎉 1 🙏🏻 1


### Chris Lee  27 minutes ago
Yes.  Correcting the plugins block to the below allows the project to be successfully executed.
```
plugins {
`java-library`

    alias(libs.plugins.m.versions)
    alias(libs.plugins.dokka)
    alias(libs.plugins.kotlin.jvm)
}
```
🎉 1  🙌🏻 1  🙏🏻 1


### Glen Peterson  3 minutes ago
```
@Suppress("DSL_SCOPE_VIOLATION")
alias(libs.plugins.m.versions)
```
Seems to suppress the IDE error.

👍 1