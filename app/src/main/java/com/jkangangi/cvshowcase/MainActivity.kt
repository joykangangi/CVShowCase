package com.jkangangi.cvshowcase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import com.jkangangi.cvshowcase.app.theme.CVShowCaseTheme
import com.jkangangi.cvshowcase.app.util.CVViewModel
import com.jkangangi.cvshowcase.cv.CVScreen
import com.jkangangi.cvshowcase.edit_cv.EditCVScreen

class MainActivity : ComponentActivity() {

    private val viewModel: CVViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CVShowCaseTheme {

                val state by viewModel.cvState.collectAsState()
                val screen by viewModel.screen.collectAsState()
                val context = LocalContext.current

                val onLinkClicked = { url: String ->
                    viewModel.onLinkClicked(webUrl = url, context = context)
                }


                when (screen) {
                    0 -> CVScreen(
                        state = state,
                        onEdit = { viewModel.navigate(1) },
                        onLinkClick = onLinkClicked
                    )

                    1 -> EditCVScreen(
                        state = state,
                        updateCV = viewModel::updateCV,
                        onSave = { viewModel.navigate(0) })
                }
            }
        }
    }
}