package org.b12x.gfe.core.controller.tabstate

class GfeSearchState : TabState {

    /* What tab */
    override fun getTab(ctx: TabStateContext) = "GFE"

    /* Version */
    override fun getCurrentVersion(ctx: TabStateContext): String {
        return "version"
    }

    // setting up so the core can identify which tab the version
    // request is coming from.
    // I can't remember why I care.
}