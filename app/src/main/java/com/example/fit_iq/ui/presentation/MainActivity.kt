package com.example.fit_iq

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.example.fit_iq.ui.presentation.Fit_iqTheme
import com.example.fit_iq.ui.presentation.navigation.NavGraph
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
 class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstancesState: Bundle?) {
        super.onCreate(savedInstancesState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            Fit_iqTheme {
                val windowSizeClass = calculateWindowSizeClass(activity = this)
                val navController = rememberNavController()
                Scaffold{
                    paddingValues ->
                    NavGraph(
                        navController = navController,
                        windowSize = windowSizeClass.widthSizeClass,
                        paddingValues = paddingValues
                    )
                }
            }
        }
    }
}











