package com.jkangangi.cvshowcase.app.widgets

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun ChipItem(modifier: Modifier = Modifier, chipText: String) {
    Box(
        modifier = modifier
            .padding(5.dp)
            .clip(RoundedCornerShape(8))
            .border(width = 1.dp, color = MaterialTheme.colorScheme.primary),
        contentAlignment = Alignment.Center,
        content = {
            Text(
                modifier = modifier.padding(5.dp),
                text = chipText,
                style = MaterialTheme.typography.bodyLarge)
        }
    )
}

@Preview
@Composable
fun PrevChipItem() {
    CVShowCaseTheme {
        ChipItem(chipText = "Joy")
    }

}