package com.luisfagundes.insightcodechalenge.feature.details

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.luisfagundes.insightcodechalenge.feature.details.presentation.DetailsRoute

const val DETAILS_ROUTE = "details/"

fun NavController.navigateToDetails() = navigate(DETAILS_ROUTE)

fun NavGraphBuilder.detailsRoute(
    onBackPressed: () -> Unit
) {
    composable(
        route = DETAILS_ROUTE,
    ) {
        DetailsRoute(
            onBackPressed = onBackPressed
        )
    }
}