package com.jkangangi.cvshowcase.app.widgets

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EditChipSection(modifier: Modifier = Modifier) {


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditChip(
    modifier: Modifier = Modifier,
    onDelete: () -> Unit,
    chipText: String,
    ) {
    InputChip(
        modifier = modifier.padding(5.dp),
        selected = true,
        onClick = onDelete,
        label = { Text(text = chipText, style = MaterialTheme.typography.bodyLarge) },
        trailingIcon = {
            Icon(imageVector = Icons.Default.Close, contentDescription = null)
        })

}