package com.jkangangi.cvshowcase.edit_cv.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jkangangi.cvshowcase.app.theme.CVShowCaseTheme
import com.jkangangi.cvshowcase.app.widgets.TextInput

/**
 * At the time of writing this function, I could not pass the
 * weights directly to the TextInputs as in CVBody with the title + date.
 * If so, it brings a cluttered layout, the 2nd TextInput looks squashed.
 * So, I resulted into using a box :(
 */
@Composable
fun EditDate(
    modifier: Modifier = Modifier,
    month: String,
    onMonthChanged: (String) -> Unit,
    txtLabelMonth: String,
    year: String,
    onYearChanged: (String) -> Unit,
    txtLabelYear: String,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        content = {
            Box(
                modifier = modifier.weight(1f),
                contentAlignment = Alignment.CenterStart
            ) {
                TextInput(
                    modifier = modifier.fillMaxWidth(),
                    input = month,
                    onInputChange = onMonthChanged,
                    txtLabel = txtLabelMonth
                )
            }

            Spacer(modifier = modifier.width(16.dp))

            Box(
                modifier = modifier.weight(1f),
                contentAlignment = Alignment.CenterStart
            ) {
                TextInput(
                    modifier = modifier.fillMaxWidth(),
                    input = year,
                    onInputChange = onYearChanged,
                    txtLabel = txtLabelYear
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PrevDate() {
    CVShowCaseTheme {
       EditDate(
           month = "Jan",
           onMonthChanged = { },
           txtLabelMonth = "Starting Month",
           year = "2024",
           onYearChanged = { },
           txtLabelYear = "Starting Year"
       )
    }
}