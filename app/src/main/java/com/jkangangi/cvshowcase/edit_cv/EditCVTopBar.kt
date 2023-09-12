package com.jkangangi.cvshowcase.edit_cv

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.jkangangi.cvshowcase.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditCVTopBar(modifier: Modifier = Modifier, onSave: () -> Unit) {

    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = stringResource(id = R.string.edit_top_bar)
            )
        },
        navigationIcon = {
            IconButton(
                onClick = { onSave() },
                content = {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = stringResource(id = R.string.close_icon)
                    )
                }
            )
        },
        actions = {
            Button(
                modifier = modifier.align(Alignment.CenterVertically),
                onClick = onSave,
                content = {
                    Text(
                        text = "Save",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            )
        }
    )
}