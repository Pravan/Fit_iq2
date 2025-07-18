package com.example.fit_iq

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.fit_iq.ui.presentation.Fit_iqTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstancesState: Bundle?) {
        super.onCreate(savedInstancesState)
        enableEdgeToEdge()
        setContent {
            Fit_iqTheme {

            }
        }
    }
}







