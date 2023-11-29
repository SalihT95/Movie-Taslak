package com.turkoglu.composedeneme.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(var route: String, val icon: ImageVector?, var title: String) {
    object Home : Screen("Home", Icons.Rounded.Home, "Home")
    object Search : Screen("Search", Icons.Rounded.Search, "Search")
    object Fav : Screen("Fav", Icons.Rounded.Favorite, "Fav")
    object Settings : Screen("Settings", Icons.Rounded.Settings, "Settings")
}