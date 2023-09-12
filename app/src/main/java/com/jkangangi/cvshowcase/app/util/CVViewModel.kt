package com.jkangangi.cvshowcase.app.util

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jkangangi.cvshowcase.app.data.StartingCV.initialCVState
import com.jkangangi.cvshowcase.cv.CVState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


/**
 * Shared View Model between CVScreen and Edit Screen
 */
class CVViewModel : ViewModel() {
    private val initialState = initialCVState

    private val _cvState = MutableStateFlow(CVState())
    val cvState = _cvState.asStateFlow()

    private val _screen = MutableStateFlow(0)
    val screen = _screen.asStateFlow()

    private var instance = 0

    fun updateCV(state: CVState) {
        _cvState.update { state }
    }

    init {
        viewModelScope.launch {
            _cvState.value = initialState
        }
        Log.i("VM INSTANCE", "INSTANCE = ${instance++}")
    }

    fun navigate(screen: Int) {
        _screen.value = screen
    }

    fun onLinkClicked(webUrl: String, context: Context) {
        viewModelScope.launch {
            try {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(webUrl))
                startActivity(context, intent, null)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(context, "NO APP FOUND", Toast.LENGTH_LONG).show()
            }
        }
    }


    //Todo Implement State Update to Screens


}