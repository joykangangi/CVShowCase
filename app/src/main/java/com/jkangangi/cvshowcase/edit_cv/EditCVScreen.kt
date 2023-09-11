package com.jkangangi.cvshowcase.edit_cv

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EditCVScreen(modifier: Modifier, onClose: () -> Unit) {
    Scaffold(
        topBar = {
            Surface(
                shadowElevation = 3.dp,
                content = {
                    EditCVTopBar(onClose = onClose)
                })
        },
        content = { innerPadding ->
// todo personal det, professional, button, state class with values initially

        }
    )

}