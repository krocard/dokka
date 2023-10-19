/*
 * Copyright 2014-2023 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
 */

import org.jetbrains.overridePublicationArtifactId

plugins {
    id("org.jetbrains.conventions.kotlin-jvm")
    id("org.jetbrains.conventions.publishing-default")
}

overridePublicationArtifactId("dokka-base-test-utils")

dependencies {
    compileOnly(projects.dokkaCore)
    compileOnly(projects.pluginBase)

    api(projects.analysisKotlinApi)

    // TODO [beresnev] analysis switcher
    //runtimeOnly(project(path = ":subprojects:analysis-kotlin-symbols", configuration = "shadow"))
    runtimeOnly(project(path = ":analysis-kotlin-descriptors", configuration = "shadow"))

    implementation(kotlin("reflect"))
    implementation(libs.jsoup)

    implementation(kotlin("test"))
    implementation(projects.coreTestApi)

    testImplementation(kotlin("test"))
    testImplementation(projects.coreTestApi)
}
