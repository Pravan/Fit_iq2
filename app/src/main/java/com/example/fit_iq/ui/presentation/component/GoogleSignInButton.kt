package com.example.fit_iq.ui.presentation.component



import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.googlefonts.GoogleFont
import com.example.fit_iq.R
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



@Composable
fun GoogleSignInButton(
    modifier: Modifier = Modifier,
    loadingState: Boolean = false,
    primaryText: String = "Sign in with Google",
    secondaryText: String = "Please wait...",
    onclick: () -> Unit
) {
    var buttonText by remember{ mutableStateOf(primaryText) }

    LaunchedEffect(key1 = loadingState) {
        buttonText = if (loadingState) secondaryText else primaryText
    }

    Button(
        modifier= modifier,
        onClick = { onclick() }
    ) {
        Icon(painter = painterResource(id = R.drawable.ic_google_logo),
            contentDescription = "Google icon",
            tint = Color.Unspecified
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = buttonText)
        if(loadingState)
        {
            Spacer(modifier = Modifier.width(8.dp))
            CircularProgressIndicator(
                modifier = Modifier.size(16.dp),
                strokeWidth = 2.dp,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )

        }

    }
}

@Preview
@Composable
private fun GoogleSignInButtonPreview() {
    Fit_iqTheme {
        GoogleSignInButton(
            loadingState = true,

            onclick = {}
        )
    }
}