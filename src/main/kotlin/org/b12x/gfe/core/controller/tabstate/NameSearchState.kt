package org.b12x.gfe.core.controller.tabstate

class NameSearchState: TabState {

    /* What tab */
    override fun getTab(ctx: TabStateContext) = "NAME"

    /* Version */
    override fun getCurrentVersion(ctx: TabStateContext): String {
        return "value"
    }
}