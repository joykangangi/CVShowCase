package com.jkangangi.cvshowcase.cv

import androidx.compose.runtime.Stable

@Stable
data class CVState(
    val fullName: String = "",
    val jobRole: String = "",
    val bio: String = "",
    val contact: Contact = Contact(),
    val techSkills: List<String> = emptyList(),
    val softSkills: List<String> = emptyList(),
    val projects: List<CVBody> = emptyList(),
    val education: List<CVBody> = emptyList(),
    val volunteer: List<CVBody> = emptyList(),
    val certifications: List<CVBody> = emptyList(),
)

data class Contact(
    val slackUserName: String = "",
    val gitHub: String = "",
    val email: String = ""
)
/*data class Contact(
    val name: String,
)*/


data class CVBody(
    val title: String = "",
    val description: String = "",
    val details: String = "",
    val duration: Duration = Duration()
)

data class Duration(
    val startingMonth: String = "",
    val startingYear: String = "",
    val endingMonth: String = "",
    val endingYear: String = ""
)


