package com.jkangangi.cvshowcase.app.util

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
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

    fun updateCV(state: CVState) {
        _cvState.update { state }
    }

    init {
        viewModelScope.launch {
            _cvState.value = initialState
        }
    }

    fun onSoftSkillDeleted(skill: String) {
        viewModelScope.launch {
            val updatedSoftSkills = _cvState.value.softSkills.toMutableList()
            if (updatedSoftSkills.remove(skill)) {
                _cvState.update { it.copy(softSkills = updatedSoftSkills) }
            }
        }
    }

    fun onTechSkillDeleted(skill: String) {
        viewModelScope.launch {
            val updatedTechSkills = _cvState.value.techSkills.toMutableList()
            if (updatedTechSkills.remove(skill)) {
                _cvState.update { it.copy(techSkills = updatedTechSkills) }
            }
        }
    }


    fun navigate(screen: Int) {
        viewModelScope.launch {
            _screen.value = screen
        }
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


}