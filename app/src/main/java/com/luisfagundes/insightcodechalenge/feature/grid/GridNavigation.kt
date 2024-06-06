package com.luisfagundes.insightcodechalenge.feature.grid

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.luisfagundes.insightcodechalenge.feature.grid.presentation.GridRoute

const val MAIN_ROUTE = "main/"

fun NavController.navigateToMain(navOptions: NavOptions) = navigate(MAIN_ROUTE, navOptions)

fun NavGraphBuilder.mainRoute() {
    composable(
        route = MAIN_ROUTE,
    ) {
        GridRoute(
            onItemClick = {}
        )
    }
}