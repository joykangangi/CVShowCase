package com.jkangangi.cvshowcase.cv

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.jkangangi.cvshowcase.R
import com.jkangangi.cvshowcase.app.theme.CVShowCaseTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CVTopAppBar(modifier: Modifier = Modifier, onEdit: () -> Unit) {

    val scrollBehaviour = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    TopAppBar(
        title = { Text(text = "Resumé") },
        modifier = modifier.nestedScroll(scrollBehaviour.nestedScrollConnection),
        actions = {
            IconButton(
                onClick = onEdit,
                content = {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = stringResource(id = R.string.edit_icon)
                    )
                })
        },
        scrollBehavior = scrollBehaviour,
    )
}

@Preview
@Composable
fun PrevCVTopBar() {
    CVShowCaseTheme {
        CVTopAppBar(onEdit = { })
    }
}