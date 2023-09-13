package com.jkangangi.cvshowcase.edit_cv.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jkangangi.cvshowcase.app.theme.CVShowCaseTheme

@Composable
fun EditChip(
    modifier: Modifier = Modifier,
    onDelete: (String) -> Unit,
    chipText: String,
) {

    Box(
        modifier = modifier
            .padding(3.dp)
            .clip(RoundedCornerShape(15))
            .border(width = 1.dp, color = MaterialTheme.colorScheme.primary),
        contentAlignment = Alignment.Center,
        content = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                content = {
                    Text(
                        modifier = modifier.padding(5.dp),
                        text = chipText,
                        style = MaterialTheme.typography.bodyLarge
                    )

                    IconButton(
                        onClick = { onDelete(chipText) },
                        content = {
                            Icon(imageVector = Icons.Default.Close, contentDescription = null)

                        }
                    )

                }
            )

        }
    )
}

@Preview
@Composable
fun PrevEditChip() {
    CVShowCaseTheme {
        EditChip(onDelete = { }, chipText = "Cleaning")
    }

}