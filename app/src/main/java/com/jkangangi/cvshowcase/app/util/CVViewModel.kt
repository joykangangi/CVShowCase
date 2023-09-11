package com.jkangangi.cvshowcase.app.util

import androidx.lifecycle.ViewModel
import com.jkangangi.cvshowcase.app.util.StartingCV.initialCVState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CVViewModel() : ViewModel() {
    val initialState = initialCVState

    private val _cvState = MutableStateFlow(CVState())
    val cvState = _cvState.asStateFlow()

    //Todo Implement Button Clicks
    //Todo Implement State Update to Screens
}