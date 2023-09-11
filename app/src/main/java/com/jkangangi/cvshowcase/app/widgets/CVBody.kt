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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


/**
 * Will be used for: Projects, Education, Volunteer, Certification
 */

@Composable
fun CVBody(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    detail: String,
    startingMonth: String,
    startingYear: String,
    endingMonth: String,
    endingYear: String,
    isClickable: Boolean = false,
    onTextClick: () -> Unit = { },
    ) {
    Column(
        modifier = modifier.padding(8.dp),
        content = {
            Row(
                modifier = modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                content = {
                    Text(text = title, style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Bold)
                    DateSection(
                        startingMonth = startingMonth ,
                        startingYear = startingYear ,
                        endingMonth = endingMonth,
                        endingYear = endingYear
                    )
                }
            )
            DescriptionText(description = description, isClickable = isClickable, onTextClick = onTextClick)
            Text(text = detail, style = MaterialTheme.typography.bodyLarge)
        }
    )
}