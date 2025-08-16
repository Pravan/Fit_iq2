package com.example.fit_iq.ui.presentation.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.toRoute
import com.example.fit_iq.ui.presentation.add_item.AddItemScreen
import com.example.fit_iq.ui.presentation.dashboard.Dashboardscreen
import com.example.fit_iq.ui.presentation.signin.signInScreen
import com.example.fit_iq.ui.presentation.details.DetailsScreen
import com.example.fit_iq.ui.presentation.signin.SignInViewModel

@Composable
fun NavGraph(
    navController: NavHostController,
    windowSize: WindowWidthSizeClass,
    paddingValues: PaddingValues

) {
    NavHost(
        navController = navController,
        startDestination = Routes.DashboardScreen
    ) {
        composable<Routes.SignInScreen> {
            val signInViewModel:SignInViewModel = SignInViewModel()
            val state by signInViewModel.state.collectAsStateWithLifecycle()
            signInScreen(
                windowSize = windowSize,
                paddingValues = paddingValues,
                state = state,
                onEvent = signInViewModel::onEvent
            )

        }
        composable<Routes.DashboardScreen> {
            Dashboardscreen(
                paddingValues = paddingValues,
                onFabClicked = { navController.navigate(Routes.AddItemScreen) },
                onItemCardClicked = { bodyPartId ->
                    navController.navigate(Routes.DetailsScreen(bodyPartId))
                }
            )
        }
        composable<Routes.AddItemScreen>(
            enterTransition ={
                slideIntoContainer(
                    animationSpec = tween(durationMillis = 500),
                    towards = AnimatedContentTransitionScope.SlideDirection.Start
                )
            } ,
            exitTransition ={
                slideOutOfContainer(
                    animationSpec = tween(durationMillis = 500),
                    towards = AnimatedContentTransitionScope.SlideDirection.End
                )
            }
        ) {
            AddItemScreen(
                paddingValues = paddingValues,
                onBackIconClick = {navController.navigateUp()}
            )
        }
        composable<Routes.DetailsScreen>(

                    enterTransition ={
                        slideIntoContainer(
                            animationSpec = tween(durationMillis = 500),
                            towards = AnimatedContentTransitionScope.SlideDirection.Start
                        )
                    } ,
            exitTransition ={
                slideOutOfContainer(
                    animationSpec = tween(durationMillis = 500),
                    towards = AnimatedContentTransitionScope.SlideDirection.End
                )
            }

        ) { navBackStackEntry ->
            val bodyPart = navBackStackEntry.toRoute<Routes.DetailsScreen>().bodyPartId


            DetailsScreen(
                paddingValues = paddingValues,
                bodyPartId = bodyPart,
                windowSize = windowSize,
                onBackIconClick = {navController.navigateUp()}
            )
        }
    }
}


