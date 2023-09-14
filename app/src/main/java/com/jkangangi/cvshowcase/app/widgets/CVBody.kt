package com.jkangangi.cvshowcase.app.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jkangangi.cvshowcase.cv.CVBody


/**
 * Will be used for: Projects, Education, Volunteer, Certifications
 */

@Composable
fun CVBody(
    modifier: Modifier = Modifier,
    body: CVBody,
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
                    Text(
                        modifier = modifier.weight(.1f),
                        text = body.title,
                        style = MaterialTheme.typography.bodyMedium
                    )
                    DateSection(
                        modifier = modifier.weight(.1f),
                        startingMonth = body.duration.startingMonth,
                        startingYear = body.duration.startingYear,
                        endingMonth = body.duration.endingMonth,
                        endingYear = body.duration.endingYear
                    )
                }
            )
            Spacer(modifier = modifier.height(10.dp))
            DescriptionText(
                description = body.description,
                isClickable = isClickable,
                onTextClick = onTextClick
            )
            Spacer(modifier = modifier.height(10.dp))
            Text(text = body.details, style = MaterialTheme.typography.bodyLarge)
        }
    )
}