package com.jkangangi.cvshowcase.cv

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Anchor
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jkangangi.cvshowcase.R
import com.jkangangi.cvshowcase.app.widgets.CVBody
import com.jkangangi.cvshowcase.app.widgets.CVHeader
import com.jkangangi.cvshowcase.app.widgets.ChipItem
import com.jkangangi.cvshowcase.app.widgets.Contact
import com.jkangangi.cvshowcase.app.widgets.VerticalDivider

@Composable
fun CVScreen(
    modifier: Modifier = Modifier,
    onEditClick: () -> Unit,
    projectsList: List<Project>, //state class
    //todo state class
) {

    Scaffold(
        topBar = { CVTopAppBar(onEdit = onEditClick) },
        content = { innerPadding ->
            Column(
                modifier = modifier
                    .padding(innerPadding)
                    .padding(12.dp)
                    .verticalScroll(
                        rememberScrollState()
                    ),
                content = {
                    BioSection(fullName =, role =, bio =)
                    ContactsSection(
                        slackUserName =,
                        gitHub =,
                        onGitClick =,
                        email =,
                        onEmailClick =
                    )
                    TechSkills(professionalSkills =)
                    SoftSkills(softSkills =)
                    Projects(
                        projectsList =,
                        onTextClick = { }
                    )
                    Education(schools = )
                    Volunteer(volunteers = )
                    Certifications(certs = )
                },
            )
        }
    )
}

@Composable
private fun BioSection(
    modifier: Modifier = Modifier,
    fullName: String,
    role: String,
    bio: String
) {
    ElevatedCard(
        modifier = modifier.padding(12.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 5.dp),
        content = {
            Text(text = fullName, style = MaterialTheme.typography.titleMedium)
            Text(text = role, style = MaterialTheme.typography.titleSmall)
            Spacer(modifier = modifier.height(5.dp))
            Text(text = bio, style = MaterialTheme.typography.bodyLarge)
        }
    )
}

@Composable
private fun ContactsSection(
    modifier: Modifier = Modifier,
    slackUserName: String,
    gitHub: String,
    onGitClick: () -> Unit,
    email: String,
    onEmailClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
        horizontalArrangement = Arrangement.SpaceEvenly,
        content = {
            Contact(iconId = R.drawable.github, contact = gitHub, onContactClick = onGitClick)
            VerticalDivider()
            Contact(iconId = R.drawable.slack, contact = slackUserName)
            VerticalDivider()
            Contact(iconId = R.drawable.email, contact = email, onContactClick = onEmailClick)
        }
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TechSkills(modifier: Modifier = Modifier, professionalSkills: List<String>) {

    //Professional Skills
    CVHeader(
        icon = Icons.Default.Build,
        header = stringResource(id = R.string.professional_skills),
        body = {
            FlowRow(
                maxItemsInEachRow = 3,
                modifier = modifier.padding(5.dp),
                content = {
                    professionalSkills.forEach { skill ->
                        ChipItem(chipText = skill)
                    }
                }
            )
        }
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun SoftSkills(modifier: Modifier = Modifier, softSkills: List<String>) {
    CVHeader(
        icon = Icons.Default.Build,
        header = stringResource(id = R.string.professional_skills),
        body = {
            FlowRow(
                maxItemsInEachRow = 3,
                modifier = modifier.padding(5.dp),
                content = {
                    softSkills.forEach { skill ->
                        ChipItem(chipText = skill)
                    }
                }
            )
        }
    )
}


@Composable
private fun Projects(
    modifier: Modifier = Modifier,
    projectsList: List<CVBody>, //todo state class w/below params
    onTextClick: () -> Unit,
) {
    CVHeader(
        icon = Icons.Default.Work,
        header = stringResource(id = R.string.projects),
        body = {
            projectsList.forEachIndexed {
                CVBody(
                    title = ,
                    description = ,
                    detail = ,
                    startingMonth = ,
                    startingYear = ,
                    endingMonth = ,
                    endingYear = ,
                    isClickable = true,
                    onTextClick = { onTextClick() },
                    modifier = modifier,
                )
            }
        }
    )
}


@Composable
private fun Education(
    modifier: Modifier = Modifier,
    schools: List<BodyEdu>,
) {
    CVHeader(
        icon = Icons.Default.School,
        header = stringResource(id = R.string.education),
        body = {
            schools.forEachIndexed { index, t ->
                CVBody(
                    title =,
                    description =,
                    detail =,
                    startingMonth =,
                    startingYear =,
                    endingMonth =,
                    endingYear =,
                    modifier = modifier
                )
            }

        }
    )
}

@Composable
private fun Volunteer(
    modifier: Modifier = Modifier,
    volunteers: List<BodyVolunteers>,
) {
    CVHeader(
        icon = Icons.Default.School,
        header = stringResource(id = R.string.education),
        body = {
            volunteers.forEachIndexed { index, t ->
                CVBody(
                    title =,
                    description =,
                    detail =,
                    startingMonth =,
                    startingYear =,
                    endingMonth =,
                    endingYear =,
                    modifier = modifier
                )
            }

        }
    )
}

@Composable
fun Certifications(
    modifier: Modifier = Modifier,
    certs: List<Certifications>,
    onTextClick: () -> Unit,
) {
    CVHeader(
        icon = Icons.Default.Anchor,
        header = stringResource(id = R.string.certs)
    ) {
        certs.forEachIndexed { index, t ->
            CVBody(
                title = ,
                description = ,
                detail = ,
                startingMonth = ,
                startingYear = ,
                endingMonth = ,
                endingYear = ,
                isClickable = true,
                onTextClick = onTextClick,
                modifier = modifier,
            )
        }
    }
}






