package org.jetbrains.dokka.base.transformers.documentables

import org.jetbrains.dokka.model.Annotations
import org.jetbrains.dokka.model.Documentable
import org.jetbrains.dokka.model.ExceptionInSupertypes
import org.jetbrains.dokka.model.properties.WithExtraProperties

val <T : Documentable> WithExtraProperties<T>.isException: Boolean
    get() = extra[ExceptionInSupertypes] != null


val <T : Documentable> WithExtraProperties<T>.deprecatedAnnotation
    get() = extra[Annotations]?.let { annotations ->
        annotations.directAnnotations.values.flatten().firstOrNull {
            it.isDeprecated()
        }
    }

/**
 * @return true if [T] has [kotlin.Deprecated] or [java.lang.Deprecated]
 *         annotation for **any** source set
 */
fun <T : Documentable> WithExtraProperties<T>.isDeprecated() = deprecatedAnnotation != null

/**
 * @return true for [kotlin.Deprecated] and [java.lang.Deprecated]
 */
fun Annotations.Annotation.isDeprecated() =
    (this.dri.packageName == "kotlin" && this.dri.classNames == "Deprecated") ||
            (this.dri.packageName == "java.lang" && this.dri.classNames == "Deprecated")
