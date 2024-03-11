/*
 * Copyright 2014-2024 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
 */

import dokkabuild.overridePublicationArtifactId

plugins {
    id("dokkabuild.kotlin-jvm")
    id("dokkabuild.publish-jvm")
    id("dokkabuild.test-k2")
}

overridePublicationArtifactId("javadoc-plugin")

dependencies {
    compileOnly(projects.dokkaSubprojects.dokkaCore)
    compileOnly(projects.dokkaSubprojects.analysisKotlinApi)

    implementation(projects.dokkaSubprojects.pluginBase)
    implementation(projects.dokkaSubprojects.pluginKotlinAsJava)

    implementation(kotlin("reflect"))
    implementation(libs.korlibs.template)
    implementation(libs.kotlinx.html)
    implementation(libs.kotlinx.coroutines.core)

    testImplementation(kotlin("test"))
    testImplementation(libs.junit.platformLauncher)
    symbolsTestConfiguration(project(path = ":dokka-subprojects:analysis-kotlin-symbols", configuration = "shadow"))
    symbolsTestConfiguration(libs.junit.platformLauncher)
    descriptorsTestConfiguration(project(path = ":dokka-subprojects:analysis-kotlin-descriptors", configuration = "shadow"))
    descriptorsTestConfiguration(libs.junit.platformLauncher)
    testImplementation(projects.dokkaSubprojects.pluginBaseTestUtils) {
        exclude(module = "analysis-kotlin-descriptors")
    }
    testImplementation(projects.dokkaSubprojects.coreTestApi)
    testImplementation(libs.jsoup)
}
