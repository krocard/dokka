/*
 * Copyright 2014-2023 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
 */

package renderers.html

import org.jetbrains.dokka.base.DokkaBaseConfiguration.Companion.defaultFooterMessage
import org.jetbrains.dokka.base.renderers.html.HtmlRenderer
import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import renderers.testPage
import utils.A
import utils.Span
import utils.match
import kotlin.test.Test

class FooterMessageTest : HtmlRenderingOnlyTestBase() {
    @Test
    fun `should include defaultFooter`() {
        val page = testPage { }
        HtmlRenderer(context).render(page)
        renderedContent.match(
            Span(A()),
            Span(defaultFooterMessage),
            Span(Span("Generated by "), A(Span("dokka"), Span()))
        )
    }

    override val renderedContent: Element
        get() = files.contents.getValue("test-page.html").let { Jsoup.parse(it) }.select(".footer").single()
}