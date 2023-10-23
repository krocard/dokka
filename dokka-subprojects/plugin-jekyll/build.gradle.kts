/*
 * Copyright 2014-2023 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
 */

import org.jetbrains.overridePublicationArtifactId

plugins {
    id("org.jetbrains.conventions.kotlin-jvm")
    id("org.jetbrains.conventions.publishing-default")
}

overridePublicationArtifactId("jekyll-plugin")

dependencies {
    compileOnly(projects.dokkaCore)

    implementation(projects.pluginBase)
    implementation(projects.pluginGfm)

    implementation(kotlin("reflect"))

    testImplementation(kotlin("test"))
    testImplementation(projects.coreTestApi)
}