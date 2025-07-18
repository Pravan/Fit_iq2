package com.example.fit_iq.ui.presentation.component



import androidx.compose.foundation.layout.Spacer

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.ui.tooling.preview.Preview
import com.example.fit_iq.ui.presentation.Fit_iqTheme
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextButton


@Composable
fun AnonymousSignInButton(
    modifier: Modifier = Modifier,
    loadingState: Boolean = false,
    primaryText: String = "Continue without login",
    secondaryText: String = "Please wait...",
    onclick: () -> Unit
) {
    var buttonText by remember{ mutableStateOf(primaryText) }

    LaunchedEffect(key1 = loadingState) {
        buttonText = if (loadingState) secondaryText else primaryText
    }

    TextButton(
        modifier= modifier,
        onClick = { onclick() }
    ) {

        Text(text = buttonText)
        if(loadingState)
        {
            Spacer(modifier = Modifier.width(8.dp))
            CircularProgressIndicator(
                modifier = Modifier.size(16.dp),
                strokeWidth = 2.dp,
                color = MaterialTheme.colorScheme.onSurface
            )

        }

    }
}

@Preview
@Composable
private fun AnonymousSignInButtonPreview() {
    Fit_iqTheme {
        AnonymousSignInButton(
            loadingState = true,

            onclick = {}
        )
    }
}