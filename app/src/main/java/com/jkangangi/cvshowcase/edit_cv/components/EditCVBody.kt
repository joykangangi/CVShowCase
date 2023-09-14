package com.jkangangi.cvshowcase.edit_cv.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jkangangi.cvshowcase.app.widgets.CVHeader
import com.jkangangi.cvshowcase.app.widgets.TextInput
import com.jkangangi.cvshowcase.cv.CVBody


/**
 * Will be used for: Projects, Education, Volunteer, Certifications
 */

@Composable
fun EditCVBody(
    modifier: Modifier = Modifier,
    body: CVBody,
    updateBody: (CVBody) -> Unit,
) {
    Column(
        modifier = modifier.padding(8.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        content = {
            TextInput(
                input = body.title,
                onInputChange = { updateBody(body.copy(title = it)) },
                txtLabel = "Title"
            )
            TextInput(
                input = body.description,
                onInputChange = { updateBody(body.copy(description = it)) },
                txtLabel = "Description"
            )
            TextInput(
                input = body.details,
                onInputChange = { updateBody(body.copy(details = it)) },
                txtLabel = "Details"
            )

            Row(
                modifier = modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                content = {
                    TextInput(
                        modifier = modifier.weight(.1f),
                        input = body.duration.startingMonth,
                        onInputChange = { updateBody(body.copy(duration = body.duration.copy(startingMonth = it))) },
                        txtLabel = "Starting Month"
                    )

                    TextInput(
                        modifier = modifier.weight(.1f) ,
                        input = body.duration.startingYear,
                        onInputChange = { updateBody(body.copy(duration = body.duration.copy(startingYear = it))) } ,
                        txtLabel = "Starting Year"
                    )
                }
            )

            Row(
                modifier = modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                content = {
                    TextInput(
                        modifier = modifier.weight(.1f),
                        input = body.duration.endingMonth,
                        onInputChange = { updateBody(body.copy(duration = body.duration.copy(endingMonth = it))) },
                        txtLabel = "Ending Month"
                    )

                    TextInput(
                        modifier = modifier.weight(.1f) ,
                        input = body.duration.endingYear,
                        onInputChange = { updateBody(body.copy(duration = body.duration.copy(endingYear = it))) } ,
                        txtLabel = "Ending Year"
                    )
                }
            )
        }
    )
}


@Composable
fun EditBodySection(
    modifier: Modifier = Modifier,
    items: List<CVBody>,
    updateCV: (List<CVBody>) -> Unit,
    icon: ImageVector,
    headerID: Int,
) {
    CVHeader(
        icon = icon,
        header = stringResource(id = headerID),
        body = {
            items.forEach { item ->
                EditCVBody(
                    body = item,
                    updateBody = { updatedItem ->
                        val updatedItems = items.map { cvBody ->
                                 if (cvBody == item) updatedItem else cvBody }
                        updateCV(updatedItems)
                    },
                    modifier = modifier,
                )
            }
        }
    )
}
