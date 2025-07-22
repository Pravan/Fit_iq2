package com.example.fit_iq.ui.presentation.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import com.example.fit_iq.ui.presentation.component.ProfilePicPlaceholder

@Composable
fun Dashboardscreen() {
    Column(
        modifier = Modifier.fillMaxHeight()
    ) {
        DashboardTopBar(
            profilePicUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT8gkNoPnjOus19SLG3UgrYWcxiS7RLzcsKzw&s ",
            onProfilePicClick = {}
        )
    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DashboardTopBar(modifier: Modifier = Modifier,
                            profilePicUrl: String?,
                            onProfilePicClick : () -> Unit
 ) {
    TopAppBar(
        modifier = modifier,
        title = { Text(text = "FIT IQ") },
        actions = {
            IconButton(onClick = {onProfilePicClick()}) {
                ProfilePicPlaceholder(
                    placeholderSize = 30.dp,
                    borderWidth = 1.dp,
                    profilePictureUrl =profilePicUrl,
                    padding = 2.dp
                )
            }


        }
    )
}






//preview
@PreviewScreenSizes
@Composable
private fun DashboardscreenPreviw(){
    Dashboardscreen()


}







