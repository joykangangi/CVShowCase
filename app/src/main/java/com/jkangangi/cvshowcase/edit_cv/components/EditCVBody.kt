package com.jkangangi.cvshowcase.edit_cv.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jkangangi.cvshowcase.app.theme.CVShowCaseTheme
import com.jkangangi.cvshowcase.app.widgets.CVHeader
import com.jkangangi.cvshowcase.app.widgets.TextInput
import com.jkangangi.cvshowcase.cv.CVBody
import com.jkangangi.cvshowcase.cv.Duration


/**
 * Will be used for: Projects, Education, Volunteer, Certifications
 */

@Composable
private fun EditCVBody(
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
            EditDate(
                month = body.duration.startingMonth,
                onMonthChanged = {
                    updateBody(
                        body.copy(
                            duration = body.duration.copy(
                                startingMonth = it
                            )
                        )
                    )
                },
                txtLabelMonth = "Starting Month",
                year = body.duration.startingYear,
                onYearChanged = {
                    updateBody(
                        body.copy(
                            duration = body.duration.copy(
                                startingYear = it
                            )
                        )
                    )
                },
                txtLabelYear = "Starting Year"
            )

            EditDate(
                month = body.duration.endingMonth,
                onMonthChanged = {
                    updateBody(
                        body.copy(
                            duration = body.duration.copy(
                                endingMonth = it
                            )
                        )
                    )
                },
                txtLabelMonth = "Ending Month",
                year = body.duration.endingYear,
                onYearChanged = {
                    updateBody(
                        body.copy(
                            duration = body.duration.copy(
                                endingYear = it
                            )
                        )
                    )
                },
                txtLabelYear = "Ending Year"
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

            Spacer(modifier = modifier.height(5.dp))
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
                        // For each project, check if it matches the current project.
                        // If it matches, replace it with the updated project.
                        // If it doesn't match, keep the project unchanged.
                        val updatedItems = items.map { cvBody ->
                            if (cvBody == item) updatedItem else cvBody
                        }
                        updateCV(updatedItems)
                    },
                    modifier = modifier,
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun PrevEditCVBody() {
    CVShowCaseTheme {
        val prevBody = CVBody(
            title = "Android Intern",
            description = "HNG Internship",
            details = "Worked with backend and design engineers to build a mobile app",
            duration = Duration(
                startingMonth = "Sep",
                startingYear = "2023",
                endingMonth = "Nov",
                endingYear = "2023"
            )
        )

        EditCVBody(body = prevBody, updateBody = { })
    }
}