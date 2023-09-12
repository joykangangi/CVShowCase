package com.jkangangi.cvshowcase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.jkangangi.cvshowcase.app.theme.CVShowCaseTheme
import com.jkangangi.cvshowcase.app.util.CVViewModel
import com.jkangangi.cvshowcase.cv.CVScreen

class MainActivity : ComponentActivity() {

    private val viewModel: CVViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CVShowCaseTheme {
                // A surface container using the 'background' color from the theme
                val state by viewModel.cvState.collectAsState()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CVScreen(state = state)

                }
            }
        }
    }
}