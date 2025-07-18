package com.example.fit_iq.ui.presentation.signin



import android.content.pm.SigningInfo
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.example.fit_iq.R
import androidx.compose.ui.tooling.preview.Preview
import com.example.fit_iq.ui.presentation.Fit_iqTheme
import com.example.fit_iq.ui.presentation.component.AnonymousSignInButton
import com.example.fit_iq.ui.presentation.component.GoogleSignInButton
import androidx.compose.ui.tooling.preview.PreviewScreenSizes

@Composable
fun SignInScreen(){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Image(painter = painterResource(id = R.drawable.app_logo),
            contentDescription = "App Logo",
            modifier = Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = " FITNESS APP",
            style = MaterialTheme.typography.headlineLarge
        )
        Text(text = "   Measure Progress, Achieve Goals",
            style = MaterialTheme.typography.bodySmall.copy(fontStyle =  FontStyle.Italic)
        )
        Spacer(modifier = Modifier.fillMaxSize(fraction = 0.4f))
        GoogleSignInButton(

            onclick = {}
        )
        Spacer(modifier = Modifier.height(20.dp))
        AnonymousSignInButton(
            onclick = {}
        )


    }


}



@PreviewScreenSizes
@Composable
private fun SignInScreenPreview(){
    Fit_iqTheme {
        SignInScreen()
    }
}