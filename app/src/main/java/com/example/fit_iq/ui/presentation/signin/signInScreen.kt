package com.example.fit_iq.ui.presentation.signin



import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.example.fit_iq.R
import com.example.fit_iq.ui.presentation.Fit_iqTheme
import com.example.fit_iq.ui.presentation.component.AnonymousSignInButton
import com.example.fit_iq.ui.presentation.component.GoogleSignInButton
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import com.example.fit_iq.ui.presentation.component.Fit_iqDialog

@Composable
fun signInScreen(
    paddingValues: PaddingValues,
    windowSize: WindowWidthSizeClass
) {



    var isSignInAnonymousDialogOpen by rememberSaveable { mutableStateOf(false) }
    Fit_iqDialog(
        isOpen = isSignInAnonymousDialogOpen,
        title = "Login anonymously?",
        body = {
            Text(
                text = "You can login anonymously, but you will not be able to save your progress after uninstalling the app . " +
                        "Are you sure Do you want to continue?"
            )
        },
        onDialogDismiss  = {isSignInAnonymousDialogOpen = false},
        onConfirmButtonClick = {isSignInAnonymousDialogOpen = false}
    )
    when (windowSize) {
        WindowWidthSizeClass.Compact -> {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            )
            {

                Image(
                    painter = painterResource(id = R.drawable.app_logo),
                    contentDescription = "App Logo",
                    modifier = Modifier.size(200.dp)
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = " FITNESS APP",
                    style = MaterialTheme.typography.headlineLarge
                )
                Text(
                    text = "   Measure Progress, Achieve Goals",
                    style = MaterialTheme.typography.bodySmall.copy(fontStyle = FontStyle.Italic)
                )
                Spacer(modifier = Modifier.fillMaxSize(fraction = 0.4f))
                GoogleSignInButton(

                    onclick = {}
                )
                Spacer(modifier = Modifier.height(20.dp))
                AnonymousSignInButton(
                    onclick = {isSignInAnonymousDialogOpen=true}
                )


            }


        }

        else -> {
            Row (
                 modifier = Modifier.fillMaxSize()
            ){
                Column(
                    modifier = Modifier.fillMaxHeight().weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Image(
                        painter = painterResource(id = R.drawable.app_logo),
                        contentDescription = "App Logo",
                        modifier = Modifier.size(200.dp)
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = " FITNESS APP",
                        style = MaterialTheme.typography.headlineLarge
                    )
                    Text(
                        text = "   Measure Progress, Achieve Goals",
                        style = MaterialTheme.typography.bodySmall.copy(fontStyle = FontStyle.Italic)
                    )
                }
                Column(
                    modifier = Modifier.fillMaxHeight().weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    GoogleSignInButton(

                        onclick = {}
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    AnonymousSignInButton(
                        onclick = {}
                    )


                }


            }

        }
    }

}




@PreviewScreenSizes
@Composable
private fun SignInScreenPreview(){
    Fit_iqTheme {
        signInScreen(
            windowSize = WindowWidthSizeClass.Medium,
            paddingValues = PaddingValues(0.dp)
        )
    }
}