package com.jkangangi.cvshowcase.app.util

/**
 * This is the pre-populated data for the app.
 */

object StartingCV {
    val initialCVState = CVState(
        fullName = "Joy W. Kangangi",
        jobRole = "Junior Android Developer",
        bio = "Committed Mathematics and Computer Science undergrad focused on mobile development with a Human Centered Design Approach.",
        contact = Contact(
            slackUserName = "Joy Kangangi",
            gitHub = "https://github.com/joykangangi",
            email = "joykangangi@gmail.com"
        ),
        techSkills = listOf("Kotlin", "Python", "MATLAB", "Data Science", "French"),
        softSkills = listOf(
            "Team Player",
            "Communication",
            "Time Management",
            "Project Management"
        ),
        projects = initialProjects,
        education = initialSchools,
        volunteer = initialVolunteer,
        certifications = initialCerts,
    )

}

private val initialProjects = listOf(
    CVBody(
        title = "English Dictionary",
        description = "https://github.com/joykangangi/En-Dictionary",
        details = "Designed and developed a mobile application that consumed a Dictionary API to facilitate word and phrase searches, alongside creating a personalized memory game for user engagement.",
        duration = Duration(
            startingMonth = "July",
            startingYear = "2023",
            endingMonth = "Sep",
            endingYear = "2023"
        )
    ),

    CVBody(
        title = "Form Builder",
        description = "https://github.com/joykangangi/form-builder",
        details = "Collaborated with 4 Android Engineers in the design, implementation, and testing of Compose Form Builder, a software library to help in the state management of forms in Jetpack Compose. \n" +
                "The product has received positive feedback with 154 stars and 17 forks on GitHub.",
        duration = Duration(
            startingMonth = "April",
            startingYear = "2022",
            endingMonth = "May",
            endingYear = "2023"
        )
    )
)

private val initialSchools = listOf(
    CVBody(
        title = "BSc.Mathematics and Computer Science",
        description = "Jomo Kenyatta University of Agriculture and Technology",
        details = "Relevant coursework: Object Oriented Programming, Simulation and Modelling, Data Structures and Algorithms.",
        duration = Duration(
            startingMonth = "Sep",
            startingYear = "2019",
            endingMonth = "Jun",
            endingYear = "2024"
        )
    )
)

private val initialVolunteer = listOf(
    CVBody(
        title = "Google Developer Students Club",
        description = "JKUAT — Main Campus",
        details = "Introduced and trained 10 new club members on core programming concepts, using Kotlin Programming Language.",
        duration = Duration(
            startingMonth = "Sep",
            startingYear = "2022",
            endingMonth = "March",
            endingYear = "2023"
        )
    ),

    CVBody(
        title = "Cherry Binders Academy, Kenya",
        description = "French and Computer Teacher",
        details = "Taught and Examined French and Computer across Grade 1 to Grade 6 (total of roughly 100 pupils) \n" +
                "Built the school website using Wix Technology which gets monthly visits of 50-70 viewers, boosting the numbers of clients significantly.",
        duration = Duration(
            startingMonth = "Sep",
            startingYear = "2019",
            endingMonth = "May",
            endingYear = "2022"
        )
    )
)

private val initialCerts = listOf(
    CVBody(
        title = "Google Africa Developer Scholarship",
        description = "https://adscerts.com/scholar/3AE3EC561BAB29E",
        details = "This program aims to engage with existing and aspiring developers to help them build the skills they need to get a job in tech after the program is over.",
        duration = Duration(
            startingMonth = "July",
            startingYear = "2022",
            endingMonth = "Jan",
            endingYear = "2023"
        )
    ),

    CVBody(
        title = "KamiLimu Apprentice Program, Kenya",
        description = "https://www.linkedin.com/company/kamilimumentorship/",
        details = "I was selected to be 1 of the 33 mentees of the 7th cohort of KamiLimu which had an acceptance rate of 25%. \n " +
                "During this enriching 8-month mentorship experience, I not only participated in the semi-finals of all competitions but also advanced to the final stage in the Innovation and ICT skills and Professional Development competitions.",
        duration = Duration(
            startingMonth = "Sep",
            startingYear = "2022",
            endingMonth = "May",
            endingYear = "2023"
        )
    )
)