package com.kshitiz.aikidsstorygenerator



//fun buildStoryPrompt(
//    name: String,
//    age: Int,
//    theme: String,
//    language: String
//): String {
//    return """
//        You are a professional children's storyteller.
//
//        Audience:
//        - Child age: $age
//        - Language: $language
//
//        STRICT RULES:
//        - No violence
//        - No fear, horror, or sadness
//        - No adult themes
//        - No negative emotions
//        - Friendly, happy, and positive tone only
//        - Safe for kids under $age years
//
//        Rules:
//        - Story length: maximum 6 short paragraphs
//        - Each paragraph: 3–4 simple sentences
//        - Keep total story under 500 words
//
//        Create a story with:
//        - Title
//        - Story
//        - Moral at the end
//
//        Theme: $theme
//        Child name: $name
//    """.trimIndent()
//}
fun buildStoryPrompt(
    name: String,
    age: Int,
    theme: String,
    language: String
): String {
    return """
        You are a children's storyteller.

        Create a bedtime story for a child with:
        - Name: $name
        - Age: $age
        - Theme: $theme
        - Language: $language
        
        Rules:
        - Story length: maximum 6 short paragraphs
        - Each paragraph: 3–4 simple sentences
        - Keep total story under 500 words

        Format:
        Title:
        Story:
        Moral:
    """.trimIndent()
}


//Rules:
//- Use simple words suitable for age $age
//- No violence, fear, or adult content
//- Friendly and positive tone
//- End with a short moral