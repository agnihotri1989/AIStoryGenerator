package com.kshitiz.aikidsstorygenerator

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun StoryScreen(
    modifier: Modifier = Modifier,
    viewModel: StoryViewModel = viewModel(
        factory = StoryViewModelFactory(GeminiRepository())
    )
) {
    val state = viewModel.uiState
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp)
    ) {

        Text("AI Story Generator ✨", style = MaterialTheme.typography.headlineMedium)

        Spacer(Modifier.height(16.dp))

        // Inputs omitted for brevity (TextField, Dropdowns)

        Button(
            onClick = {
                viewModel.generateStory(
                    name = "Aarav",
                    age = 6,
                    theme = "Animals",
                    language = "English"
                )
            }
        ) {
            Text("Create Story")
        }

        Spacer(Modifier.height(16.dp))

        when {
            state.isLoading -> CircularProgressIndicator()
            state.error != null -> Text(state.error!!, color = Color.Red)
            state.story.isNotEmpty() -> {
                Text(
                    text = state.story,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}