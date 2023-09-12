package com.jkangangi.cvshowcase.app.util

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jkangangi.cvshowcase.app.data.StartingCV.initialCVState
import com.jkangangi.cvshowcase.cv.CVState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


/**
 * Shared View Model between CVScreen and Edit Screen
 */
class CVViewModel : ViewModel() {
    private val initialState = initialCVState

    private val _cvState = MutableStateFlow(CVState())
    val cvState = _cvState.asStateFlow()

    private var instance = 0

    init {
        viewModelScope.launch {
            _cvState.value = initialState
        }

        Log.i("VM INSTANCE", "INSTANCE = ${instance++}")
    }
    //Todo Implement Button Clicks
    //Todo Implement State Update to Screens
    //Todo Implement Navigation btween Screens


}