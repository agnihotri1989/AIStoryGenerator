# AIStoryGenerator

#Important

High level architecture




    UI(Jetpack Compose)
    └── ViewModel (State + Events)
        └── UseCase (GenerateStory)
            └── GeminiRepository
                └── Gemini SDK (Text → Text)


Dependencies

dependencies {
implementation("com.google.ai.client.generativeai:generativeai:0.7.0")
}


Edge Cases 

•	AI returns empty response

•	Token overflow

•	Network failure

•	Age outside range

•	Language fallback