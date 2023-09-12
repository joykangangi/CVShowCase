package com.jkangangi.cvshowcase.cv

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Anchor
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.FrontHand
import androidx.compose.material.icons.filled.Handshake
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jkangangi.cvshowcase.R
import com.jkangangi.cvshowcase.app.data.StartingCV
import com.jkangangi.cvshowcase.app.theme.CVShowCaseTheme
import com.jkangangi.cvshowcase.app.widgets.CVBody
import com.jkangangi.cvshowcase.app.widgets.CVHeader
import com.jkangangi.cvshowcase.app.widgets.ChipItem
import com.jkangangi.cvshowcase.app.widgets.Contact

@Composable
fun CVScreen(
    modifier: Modifier = Modifier,
    state: CVState,
) {

    Scaffold(
        topBar = { CVTopAppBar(onEdit = {  }) },
        content = { innerPadding ->
            Column(
                modifier = modifier
                    .padding(innerPadding)
                    .padding(12.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    .verticalScroll(rememberScrollState()),
                content = {
                    BioSection(
                        fullName = state.fullName,
                        role = state.jobRole,
                        bio = state.bio
                    )
                    ContactsSection(
                        slackUserName = state.contact.slackUserName,
                        gitHub = state.contact.gitHub,
                        onGitClick = {  },
                        email = state.contact.email,
                        onEmailClick = {  }
                    )
                    TechSkills(professionalSkills = state.techSkills)
                    SoftSkills(softSkills = state.softSkills)
                    Projects(
                        projects = state.projects,
                        onProjectClick = { }
                    )
                    Education(schools = state.education)
                    Volunteer(volunteers = state.volunteer)
                    Certifications(certs = state.certifications, onCertClick = { })
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
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 5.dp),
        content = {
            Column(
                modifier = modifier.padding(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                content = {
                    Text(text = fullName, style = MaterialTheme.typography.titleMedium)
                    Spacer(modifier = modifier.height(3.dp))
                    Text(text = role, style = MaterialTheme.typography.titleSmall)
                    Spacer(modifier = modifier.height(5.dp))
                    Text(text = bio, style = MaterialTheme.typography.bodyLarge)
                    Spacer(modifier = modifier.height(10.dp))
                }
            )
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
    Column(
        modifier = modifier.height(IntrinsicSize.Min),
        horizontalAlignment = Alignment.CenterHorizontally,
        content = {
            Contact(iconId = R.drawable.github, contact = gitHub, onContactClick = onGitClick)
            Contact(iconId = R.drawable.slack, contact = slackUserName)
            Contact(iconId = R.drawable.email, contact = email, onContactClick = onEmailClick)
        }
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TechSkills(modifier: Modifier = Modifier, professionalSkills: List<String>) {

    CVHeader(
        icon = Icons.Default.Build,
        header = stringResource(id = R.string.professional_skills),
        body = {
            FlowRow(
                maxItemsInEachRow = 4,
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
        icon = Icons.Default.Handshake,
        header = stringResource(id = R.string.soft_skills),
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
    projects: List<CVBody>,
    onProjectClick: () -> Unit,
) {
    CVHeader(
        icon = Icons.Default.Work,
        header = stringResource(id = R.string.projects),
        body = {
            projects.forEach { project ->
                CVBody(
                    title = project.title,
                    description = project.description,
                    detail = project.details,
                    startingMonth = project.duration.startingMonth,
                    startingYear = project.duration.startingYear,
                    endingMonth = project.duration.endingMonth,
                    endingYear = project.duration.endingYear,
                    isClickable = true,
                    onTextClick = { onProjectClick() },
                    modifier = modifier,
                )
            }
        }
    )
}


@Composable
private fun Education(
    modifier: Modifier = Modifier,
    schools: List<CVBody>,
) {
    CVHeader(
        icon = Icons.Default.School,
        header = stringResource(id = R.string.education),
        body = {
            schools.forEach { school ->
                CVBody(
                    title = school.title,
                    description = school.description,
                    detail = school.details,
                    startingMonth = school.duration.startingMonth,
                    startingYear = school.duration.startingYear,
                    endingMonth = school.duration.endingMonth,
                    endingYear = school.duration.endingYear,
                    modifier = modifier
                )
            }

        }
    )
}

@Composable
private fun Volunteer(
    modifier: Modifier = Modifier,
    volunteers: List<CVBody>,
) {
    CVHeader(
        icon = Icons.Default.FrontHand,
        header = stringResource(id = R.string.volunteer),
        body = {
            volunteers.forEach { volunteer ->
                CVBody(
                    title = volunteer.title,
                    description = volunteer.description,
                    detail = volunteer.details,
                    startingMonth = volunteer.duration.startingMonth,
                    startingYear = volunteer.duration.startingYear,
                    endingMonth = volunteer.duration.endingMonth,
                    endingYear = volunteer.duration.endingYear,
                    modifier = modifier
                )
            }
        }
    )
}

@Composable
private fun Certifications(
    modifier: Modifier = Modifier,
    certs: List<CVBody>,
    onCertClick: () -> Unit,
) {
    CVHeader(
        icon = Icons.Default.Anchor,
        header = stringResource(id = R.string.certs)
    ) {
        certs.forEach { cert ->
            CVBody(
                title = cert.title,
                description = cert.description,
                detail = cert.details,
                startingMonth = cert.duration.startingMonth,
                startingYear = cert.duration.startingYear,
                endingMonth = cert.duration.endingMonth,
                endingYear = cert.duration.endingYear,
                isClickable = true,
                onTextClick = onCertClick,
                modifier = modifier,
            )
        }
    }
}

@Preview
@Composable
fun PrevCVScreen() {
    CVShowCaseTheme {
        val initialState = StartingCV.initialCVState
        CVScreen(state = initialState)
    }
}