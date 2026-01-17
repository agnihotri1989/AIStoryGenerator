package com.kshitiz.aikidsstorygenerator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

data class StoryUiState(
    val isLoading: Boolean = false,
    val story: String = "",
    val error: String? = null
)

class StoryViewModel(
    private val repository: GeminiRepository
) : ViewModel() {

    var uiState by mutableStateOf(StoryUiState())
        private set

    fun generateStory(name: String, age: Int, theme: String, language: String) {
        viewModelScope.launch {
            uiState = uiState.copy(isLoading = true, error = null)

            try {
                val prompt = buildStoryPrompt(name, age, theme, language)
                val story = repository.generateStory(prompt)
                uiState = uiState.copy(isLoading = false, story = story)
            } catch (e: Exception) {
                uiState = uiState.copy(
                    isLoading = false,
                   // error = "Something went wrong"
                    error = e.message
                )
            }
        }
    }
}

class StoryViewModelFactory(private val repository: GeminiRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StoryViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return StoryViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}