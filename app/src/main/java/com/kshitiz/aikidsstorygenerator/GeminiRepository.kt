package com.kshitiz.aikidsstorygenerator


import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.HarmCategory
import com.google.ai.client.generativeai.type.SafetySetting
import com.google.ai.client.generativeai.type.generationConfig

class GeminiRepository {

    private val model = GenerativeModel(
        modelName = "gemini-3-flash-preview",
        apiKey = BuildConfig.GEMINI_API_KEY,
        generationConfig = generationConfig {
            temperature = 0.6f   // Creative but controlled
            maxOutputTokens = 1500
        }
    )
//    private val model = GenerativeModel(
//        modelName = "gemini-pro",
//        apiKey = BuildConfig.GEMINI_API_KEY,
//        generationConfig = generationConfig {
//            temperature = 0.8f   // Creative but controlled
//            maxOutputTokens = 800
//        },
//        safetySettings = listOf(
//            SafetySetting(HarmCategory.HARASSMENT, HarmBlockThreshold.BLOCK_LOW_AND_ABOVE),
//            SafetySetting(HarmCategory.HATE_SPEECH, HarmBlockThreshold.BLOCK_LOW_AND_ABOVE),
//            SafetySetting(HarmCategory.SEXUALLY_EXPLICIT, HarmBlockThreshold.BLOCK_LOW_AND_ABOVE)
//        )
//    )

    suspend fun generateStory(prompt: String): String {
        val response = model.generateContent(prompt)
        return response.text ?: "Sorry, I couldn't create a story right now."
    }
}