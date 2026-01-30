package com.example.viaclara.navigation

import org.jetbrains.compose.resources.DrawableResource
import viaclara.composeapp.generated.resources.Res
import viaclara.composeapp.generated.resources.calendar
import viaclara.composeapp.generated.resources.home
import viaclara.composeapp.generated.resources.share

/**
 * Sealed class representing bottom navigation tabs.
 */
sealed class TabItem(
    val label: String,
    val icon: DrawableResource
) {
    object Home : TabItem(
        label = "Home",
        icon = Res.drawable.home
    )

    object Calendar : TabItem(
        label = "Insights",
        icon = Res.drawable.calendar
    )

    object Share : TabItem(
        label = "Share",
        icon = Res.drawable.share
    )

    companion object {
        // Explicitly create the list to ensure non-null values
        fun getAllTabs(): List<TabItem> {
            return listOf(
                Home,
                Calendar,
                Share
            )
        }
    }
}