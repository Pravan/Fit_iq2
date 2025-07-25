package com.example.fit_iq.ui.presentation.component

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.TextButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun Fit_iqDialog(modifier: Modifier=Modifier,
                 isOpen:Boolean,
                 title:String,
                 confirmButtonText:String = "yes",
                 dismissButtonText:String = "Cancel",
                 body:@Composable (() -> Unit)? = null,
                 onDialogDismiss: () -> Unit,
                 onConfirmButtonClick: () -> Unit
) {
    if(isOpen){
        AlertDialog(
            modifier = modifier,
            title = {Text(text = title) },
            text = body,
            onDismissRequest = {onDialogDismiss() },
            confirmButton = {
                TextButton(onClick = {onConfirmButtonClick()}) {
                    Text(text = confirmButtonText)
                }


            },
            dismissButton = {
                TextButton(onClick = {onConfirmButtonClick()}) {
                    Text(text = dismissButtonText)
                }

            }
        )
    }

}

@Preview
@Composable
private fun  Fit_iqDialogPreview() {
    Fit_iqDialog(
        isOpen = true,
        title = "Login anonymously?",
        body = {
            Text(
                text = "You can login anonymously, but you will not be able to save your progress after uninstalling the app . " +
                        "Are you sure Do you want to continue?"
            )
        },
        onDialogDismiss = {},
        onConfirmButtonClick = {}
    )
}
