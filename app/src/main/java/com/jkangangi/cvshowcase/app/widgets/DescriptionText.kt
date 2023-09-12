package com.jkangangi.cvshowcase.app.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import com.jkangangi.cvshowcase.app.theme.CVShowCaseTheme

@Composable
fun DescriptionText(
    modifier: Modifier = Modifier,
    description: String,
    isClickable: Boolean = false,
    onTextClick: () -> Unit = { },
) {
    Text(
        text = description,
        style = MaterialTheme.typography.titleSmall,
        modifier = modifier.clickable(enabled = isClickable, onClick = onTextClick),
        textDecoration = if (isClickable) TextDecoration.Underline else TextDecoration.None,
    )
}

@Preview
@Composable
fun PrevDescText() {
    CVShowCaseTheme {
        Column {
            DescriptionText(description = "This is a description")
            DescriptionText(description = "This is a clickable description", isClickable = true)
        }
    }
}