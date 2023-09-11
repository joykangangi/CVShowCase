package com.jkangangi.cvshowcase.app.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp

@Composable
fun DateSection(
    modifier: Modifier = Modifier,
    startingMonth: String,
    startingYear: String,
    endingMonth: String,
    endingYear: String
) {

    val starting = buildAnnotatedString {
        append("$startingMonth, ")
        append("$startingYear —")
    }

    val ending = buildAnnotatedString {
        append("$endingMonth, ")
        append(endingYear)
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(5.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        content = {
            Text(text = starting, style = MaterialTheme.typography.bodyMedium)
            Text(text = ending, style = MaterialTheme.typography.bodyMedium)
        }
    )


}