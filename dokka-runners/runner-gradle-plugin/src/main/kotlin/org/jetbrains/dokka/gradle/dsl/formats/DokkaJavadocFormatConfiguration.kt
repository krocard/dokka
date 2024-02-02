/*
 * Copyright 2014-2024 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
 */

package org.jetbrains.dokka.gradle.dsl.formats

import org.jetbrains.dokka.gradle.dsl.DokkaGradlePluginDsl

// empty, for now?
@DokkaGradlePluginDsl
public interface DokkaJavadocFormatConfiguration : DokkaFormatConfiguration
// TODO: need to warn if javadoc is used in kotlin-multiplatform