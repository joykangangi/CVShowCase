package com.jkangangi.cvshowcase.edit_cv

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Anchor
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.FrontHand
import androidx.compose.material.icons.filled.Handshake
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Work
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
import com.jkangangi.cvshowcase.edit_cv.components.EditChip
import com.jkangangi.cvshowcase.edit_cv.components.EditList

@Composable
fun EditCVScreen(
    modifier: Modifier = Modifier,
    state: CVState,
    updateCV: (CVState) -> Unit,
    onDeleteSoftSkill: (String) -> Unit,
    onDeleteTechSkill: (String) -> Unit,
    onSave: () -> Unit,
) {
    Scaffold(
        topBar = { EditCVTopBar(onSave = onSave) },
        content = { innerPadding ->
            Column(
                modifier = modifier
                    .padding(innerPadding)
                    .padding(12.dp)
                    .verticalScroll(rememberScrollState()),
                content = {
                    EditPersonalInfo(state = state, updateCV = updateCV)
                    EditContact(state = state, updateCV = updateCV)
                    EditTechSkills(state = state, onDeleteSkill = onDeleteTechSkill)
                    EditSoftSkills(state = state, onDeleteSkill = onDeleteSoftSkill)
                    EditList(
                        items = state.projects,
                        updateCV = { newProjects -> updateCV(state.copy(projects = newProjects)) } ,
                        icon =  Icons.Default.Work,
                        header = R.string.edit_proj
                    )
                    EditList(
                        items = state.education,
                        updateCV = { newSchools -> updateCV(state.copy(education = newSchools)) } ,
                        icon =  Icons.Default.School,
                        header = R.string.edit_edu
                    )
                    EditList(
                        items = state.volunteer,
                        updateCV = { newVolunteer -> updateCV(state.copy(volunteer = newVolunteer)) } ,
                        icon =  Icons.Default.FrontHand,
                        header = R.string.edit_volunteer
                    )
                    EditList(
                        items = state.certifications,
                        updateCV = { newCerts -> updateCV(state.copy(projects = newCerts)) } ,
                        icon =  Icons.Default.Anchor,
                        header = R.string.edit_cert
                    )
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
                        onInputChange = { updateCV(state.copy(contact = state.contact.copy(slackUserName = it))) },
                        txtLabel = "Slack UserName"
                    )

                    TextInput(
                        input = state.contact.email,
                        onInputChange = { updateCV(state.copy(contact = state.contact.copy(email = it))) },
                        txtLabel = "Email"
                    )
                }
            )
        }
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun EditTechSkills(
    modifier: Modifier = Modifier,
    state: CVState,
    onDeleteSkill: (String) -> Unit,
) {
    CVHeader(
        icon = Icons.Default.Build,
        header = stringResource(id = R.string.edit_tech),
        body = {
            Column(
                modifier = modifier.padding(5.dp),
                content = {
                    FlowRow(
                        maxItemsInEachRow = 4,
                        modifier = modifier.padding(5.dp),
                        content = {
                            state.techSkills.forEach { skill ->
                                EditChip(
                                    onDelete = { onDeleteSkill(it) },
                                    chipText = skill
                                )
                            }
                        }
                    )
                }
            )

        }
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun EditSoftSkills(
    modifier: Modifier = Modifier,
    state: CVState,
    onDeleteSkill: (String) -> Unit,
) {
    CVHeader(
        icon = Icons.Default.Handshake,
        header = stringResource(id = R.string.edit_soft),
        body = {
            Column(
                modifier = modifier.padding(5.dp),
                content = {
                    FlowRow(
                        maxItemsInEachRow = 4,
                        modifier = modifier.padding(5.dp),
                        content = {
                            state.softSkills.forEach { skill ->
                                EditChip(
                                    onDelete = { onDeleteSkill(it) },
                                    chipText = skill
                                )
                            }
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
        EditCVScreen(
            state = initialState,
            updateCV = { },
            onSave = { },
            onDeleteSoftSkill = { },
            onDeleteTechSkill = { },
        )
    }
}