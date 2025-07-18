package com.example.fit_iq

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import com.example.fit_iq.ui.presentation.Fit_iqTheme
import com.example.fit_iq.ui.presentation.signin.signInScreen

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstancesState: Bundle?) {
        super.onCreate(savedInstancesState)
        enableEdgeToEdge()
        setContent {
            Fit_iqTheme {
                val windowSizeClass = calculateWindowSizeClass(activity = this)
                signInScreen(windowSize = windowSizeClass.widthSizeClass )


            }
        }
    }
}







