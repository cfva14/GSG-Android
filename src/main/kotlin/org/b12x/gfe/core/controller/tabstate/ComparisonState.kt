package org.b12x.gfe.core.controller.tabstate

class ComparisonState: TabState {

    /* What tab */
    override fun getTab(ctx: TabStateContext) = "COMP"

    /* Version */
    override fun getCurrentVersion(ctx: TabStateContext): String {
        return "version"
    }
}