# AIStoryGenerator

#Important

High level architecture

UI (Jetpack Compose)

    └── ViewModel (State + Events)
        └── UseCase (GenerateStory)
            └── GeminiRepository
                    └── Gemini SDK (Text → Text)