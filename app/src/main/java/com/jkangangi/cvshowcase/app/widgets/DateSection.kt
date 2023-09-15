package com.jkangangi.cvshowcase.app.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jkangangi.cvshowcase.app.theme.CVShowCaseTheme

@Composable
fun DateSection(
    modifier: Modifier = Modifier,
    startingMonth: String,
    startingYear: String,
    endingMonth: String,
    endingYear: String
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(5.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        content = {
            DateColumn(month = startingMonth, year = startingYear)
            Text(text = "—")
            DateColumn(month = endingMonth, year = endingYear)
        }
    )
}

@Composable
private fun DateColumn(
    modifier: Modifier = Modifier,
    month: String,
    year: String
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceEvenly,
        content = {
            Text(text = month, style = MaterialTheme.typography.bodyMedium)
            Text(text = year, style = MaterialTheme.typography.bodyMedium)
        }
    )
}

@Preview
@Composable
fun PrevDateSection() {
    CVShowCaseTheme {
        DateSection(
            startingMonth = "Sep",
            startingYear = "2023",
            endingMonth = "Dec",
            endingYear = "2023"
        )
    }
}