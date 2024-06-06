package com.luisfagundes.insightcodechalenge.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.luisfagundes.insightcodechalenge.feature.details.detailsRoute
import com.luisfagundes.insightcodechalenge.feature.grid.MAIN_ROUTE
import com.luisfagundes.insightcodechalenge.feature.grid.mainRoute

@Composable
fun MainApp(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = MAIN_ROUTE,
    ) {
        mainRoute()
        detailsRoute { navController.popBackStack() }
    }
}