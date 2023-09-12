package com.jkangangi.cvshowcase.edit_cv

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jkangangi.cvshowcase.R
import com.jkangangi.cvshowcase.app.data.StartingCV
import com.jkangangi.cvshowcase.app.theme.CVShowCaseTheme
import com.jkangangi.cvshowcase.app.widgets.CVHeader
import com.jkangangi.cvshowcase.app.widgets.TextInput
import com.jkangangi.cvshowcase.cv.CVState

@Composable
fun EditCVScreen(
    modifier: Modifier = Modifier,
    state: CVState,
    updateCV: (CVState) -> Unit,
    onSave: () -> Unit,
) {
    Scaffold(
        topBar = { EditCVTopBar(onSave = onSave) },
        content = { innerPadding ->
            Column(
                modifier = modifier
                    .padding(innerPadding)
                    .padding(12.dp),
                content = {
                    EditPersonalInfo(state = state, updateCV = updateCV)
                    EditContact(state = state, updateCV = updateCV)

                }
            )
        }
    )
}

@Composable
private fun EditPersonalInfo(
    modifier: Modifier = Modifier,
    state: CVState,
    updateCV: (CVState) -> Unit,
) {
    CVHeader(
        icon = Icons.Default.Person,
        header = stringResource(id = R.string.edit_persono),
        body = {
            Column(
                modifier = modifier.padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                content = {
                    TextInput(
                        input = state.fullName,
                        onInputChange = { updateCV(state.copy(fullName = it)) },
                        txtLabel = "Full Name"
                    )
                    TextInput(
                        input = state.jobRole,
                        onInputChange = { updateCV(state.copy(jobRole = it)) },
                        txtLabel = "Job Description"
                    )

                    TextInput(
                        input = state.bio,
                        onInputChange = { updateCV(state.copy(bio = it)) },
                        txtLabel = "About Me"
                    )

                }
            )
        }
    )
}

@Composable
private fun EditContact(
    modifier: Modifier = Modifier,
    state: CVState,
    updateCV: (CVState) -> Unit,
) {
    CVHeader(
        icon = Icons.Default.Phone,
        header = stringResource(id = R.string.edit_contacts),
        body = {
            Column(
                modifier = modifier.padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                content = {
                    TextInput(
                        input = state.contact.gitHub,
                        onInputChange = { updateCV(state.copy(contact = state.contact.copy(gitHub = it))) },
                        txtLabel = "GitHub Link"
                    )
                    TextInput(
                        input = state.contact.slackUserName,
                        onInputChange = {
                            updateCV(
                                state.copy(
                                    contact = state.contact.copy(slackUserName = it)
                                )
                            )
                        },
                        txtLabel = "Slack UserName"
                    )

                    TextInput(
                        input = state.contact.email,
                        onInputChange = {
                            updateCV(
                                state.copy(
                                    contact = state.contact.copy(email = it)
                                )
                            )
                        },
                        txtLabel = "Email"
                    )
                }
            )
        }
    )
}

@Composable
private fun EditTechSkills(
    modifier: Modifier = Modifier,
    state: CVState,
    updateCV: (CVState) -> Unit
) {
    CVHeader(
        icon = Icons.Default.Build,
        header = stringResource(id = R.string.edit_tech),
        body = {
            Column(
                modifier = modifier.padding(5.dp),
                content = {
                    Row(
                        modifier = modifier.padding(5.dp),
                        content = {
                            TextInput(input = "", onInputChange = {
                                updateCV(state.copy(techSkills = state.techSkills.add(it)))
                            }, txtLabel = "Skills")
                        }
                    )
                }
            )

        }
    )
}

@Preview
@Composable
fun PrevEditScreen() {
    CVShowCaseTheme {
        val initialState = StartingCV.initialCVState
        EditCVScreen(state = initialState, updateCV = { }, onSave = { })
    }

}