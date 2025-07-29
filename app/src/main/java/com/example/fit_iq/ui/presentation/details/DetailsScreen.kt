package com.example.fit_iq.ui.presentation.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fit_iq.domain.model.BodyPart
import com.example.fit_iq.domain.model.MeasuringUnit
import com.example.fit_iq.ui.presentation.Fit_iqTheme
import com.example.fit_iq.ui.presentation.component.Fit_iqDialog
import com.example.fit_iq.ui.presentation.component.MeasuringUnitBottomSheet
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(){
    val scope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    var isMeasuringUnitBottomSheetOpen by remember { mutableStateOf(false,)}
    MeasuringUnitBottomSheet(
        isOpen =isMeasuringUnitBottomSheetOpen ,
        sheetState = sheetState,
        onBottomSheetDismiss = {isMeasuringUnitBottomSheetOpen=false},
        onItemClicked = {
            scope.launch{ sheetState.hide() }.invokeOnCompletion {
                if(!sheetState.isVisible) {
                    isMeasuringUnitBottomSheetOpen = false
                }
            }
        }
    )

    var isDeleteBodyPartDialogOpen by rememberSaveable { mutableStateOf(false) }
    Fit_iqDialog(
        isOpen = isDeleteBodyPartDialogOpen,
        title = "DeleteBodyPart?",
        body = {
            Text(
                text = "Are you Sure you want to delete this body part? " +
                        "data will removed permanently .\nThis action cannot be undone."
            )
        },
        confirmButtonText = "Delete",
        onDialogDismiss  = {isDeleteBodyPartDialogOpen = false},
        onConfirmButtonClick = {isDeleteBodyPartDialogOpen = false}
    )
    Column(
        modifier = Modifier.fillMaxSize()
    ){
        DetailsTopBar(
            bodyPart = BodyPart(name = "shoulder", isActive = true, measuringUnit = MeasuringUnit.CM.code) ,
            onBackIconClick = {},
            onDeleteIconClick =  {isDeleteBodyPartDialogOpen= true },
            onUnitIconClick = {isMeasuringUnitBottomSheetOpen= true }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DetailsTopBar(modifier: Modifier = Modifier,
                          bodyPart: BodyPart?,
                          onDeleteIconClick : () -> Unit,
                          onBackIconClick:() ->Unit,
                          onUnitIconClick: () -> Unit
) {
    TopAppBar(
        modifier = modifier,
        title = { Text(text = bodyPart?.name ?:" ", maxLines = 1, overflow = TextOverflow.Ellipsis) },


        navigationIcon = {
            IconButton(onClick = { onBackIconClick() }) {

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = " Navigation Back",
                )


            }


        },

        actions = {
            IconButton(onClick = { onDeleteIconClick() }) {

                Icon(
                    imageVector = Icons.Rounded.Delete,
                    contentDescription = "Delete",
                )


            }
            Spacer(modifier=Modifier.width(4.dp))
            Text(text = bodyPart?.measuringUnit ?:"")
            IconButton(onClick = { onUnitIconClick() }) {

                Icon(
                    imageVector = Icons.Rounded.ArrowDropDown,
                    contentDescription = "Select Unit"
                )


            }



        }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun DetailsScreenPreview() {
    Fit_iqTheme {
        DetailsScreen()
    }
}