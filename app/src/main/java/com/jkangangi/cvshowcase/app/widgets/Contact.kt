package com.jkangangi.cvshowcase.app.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jkangangi.cvshowcase.R
import com.jkangangi.cvshowcase.app.theme.CVShowCaseTheme


@Composable
fun Contact(
    modifier: Modifier = Modifier,
    iconId: Int,
    contact: String,
    isClickable: Boolean = false,
    onContactClick: () -> Unit = { },
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        content = {
            Image(
                modifier = modifier.size(24.dp),
                painter = painterResource(id = iconId),
                contentDescription = stringResource(id = R.string.contact_icon))
            DescriptionText(description = contact, isClickable = isClickable, onTextClick = onContactClick)
        }
    )
}

@Preview
@Composable
fun PrevContact() {
    CVShowCaseTheme {
        Contact(iconId = R.drawable.email, contact = "joykangangi@gmail.com")
    }

}