package org.b12x.gfe.core.controller.tabstate

import org.b12x.gfe.plugins.gfesearch.controller.locistategfesearch.LociStateContextGfeSearch

interface TabState {

    /* What Tab */
    fun getTab(ctx: TabStateContext): String

    /* Version */
    fun getCurrentVersion(ctx: TabStateContext): String

}