package com.example.fit_iq.ui.presentation.details

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fit_iq.domain.model.BodyPart
import com.example.fit_iq.domain.model.BodyPartValue
import com.example.fit_iq.domain.model.MeasuringUnit
import com.example.fit_iq.domain.model.TimeRange
import com.example.fit_iq.ui.presentation.Fit_iqTheme
import com.example.fit_iq.ui.presentation.component.Fit_iqDialog
import com.example.fit_iq.ui.presentation.component.LineGraph
import com.example.fit_iq.ui.presentation.component.MeasuringUnitBottomSheet
import kotlinx.coroutines.launch
import java.time.LocalDate


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

    var selectedTimeRange by remember { mutableStateOf(TimeRange.LAST7DAYS)}
    Column(
        modifier = Modifier.fillMaxSize()
    ){
        DetailsTopBar(
            bodyPart = BodyPart(name = "shoulder", isActive = true, measuringUnit = MeasuringUnit.CM.code) ,
            onBackIconClick = {},
            onDeleteIconClick =  {isDeleteBodyPartDialogOpen= true },
            onUnitIconClick = {isMeasuringUnitBottomSheetOpen= true }
        )
        ChartTimeRangeButtons(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            selectedTimeRange = selectedTimeRange,
            onClick = {
                selectedTimeRange = it
            }

        )

        LineGraph(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(ratio = 2 / 1f)
                .padding(16.dp),
            bodyPartValues = dummyBodyPartValues
        )

    }
}
val dummyBodyPartValues = listOf(
    BodyPartValue(value = 72.0f, date = LocalDate.of(2023, 5, 10)),
    BodyPartValue(value = 76.84865145f, date = LocalDate.of(2023, 5, 1)),
    BodyPartValue(value = 74.0f, date = LocalDate.of(2023, 4, 20)),
    BodyPartValue(value = 75.1f, date = LocalDate.of(2023, 4, 5)),
    BodyPartValue(value = 66.3f, date = LocalDate.of(2023, 3, 15)),
    BodyPartValue(value = 67.2f, date = LocalDate.of(2023, 3, 10)),
    BodyPartValue(value = 73.5f, date = LocalDate.of(2023, 3, 1)),
    BodyPartValue(value = 69.8f, date = LocalDate.of(2023, 2, 18)),
    BodyPartValue(value = 68.4f, date = LocalDate.of(2023, 2, 1)),
    BodyPartValue(value = 72.0f, date = LocalDate.of(2023, 1, 22)),
    BodyPartValue(value = 70.5f, date = LocalDate.of(2023, 1, 14))
)



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
@Composable

private fun ChartTimeRangeButtons(
    modifier: Modifier = Modifier,
    selectedTimeRange: TimeRange,
    onClick: (TimeRange) -> Unit
) {
    val timeRanges = listOf(
        TimeRange.LAST7DAYS,
        TimeRange.LAST30DAYS,
        TimeRange.ALL_TIME
    )

    Row(
        modifier = modifier
            .height(40.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        timeRanges.forEach { timeRange ->
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(8.dp))
                    .background(
                        if (timeRange == selectedTimeRange)
                            MaterialTheme.colorScheme.surface
                        else
                            Color.Transparent
                    )
                    .clickable { onClick(timeRange) },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = timeRange.label,
                    style = if (timeRange == selectedTimeRange) {
                        MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold)
                    } else {
                        MaterialTheme.typography.labelLarge.copy(color = Color.Gray)
                    },
                    maxLines = 1
                )
            }
        }
    }
}




@Composable
fun TimeRangeSelectionButton(
    modifier: Modifier = Modifier,
    label:String,
    labelTextStyle: androidx.compose.ui.text.TextStyle,
    backgroundColor:Color,
    onClick:()->Unit
) {
    Box(modifier = Modifier
            .fillMaxSize()
            .padding(4.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable(
                interactionSource = remember { MutableInteractionSource()},
                indication = null,
                onClick = onClick


            )
        .background(backgroundColor),
        contentAlignment = Alignment.Center
    ){
        Text(text = label, style = labelTextStyle, maxLines = 1)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun DetailsScreenPreview() {
    Fit_iqTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            DetailsScreen()
        }
    }
}
