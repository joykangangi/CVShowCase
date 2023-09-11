package com.jkangangi.cvshowcase.edit_cv

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.jkangangi.cvshowcase.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditCVTopBar(modifier: Modifier = Modifier, onClose: () -> Unit) {

    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = stringResource(id = R.string.edit_top_bar)
            )
        },
        navigationIcon = {
            IconButton(
                onClick = { onClose() },
                content = {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = stringResource(id = R.string.close_icon)
                    )
                }
            )
        }
    )
}