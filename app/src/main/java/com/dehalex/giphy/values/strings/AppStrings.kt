package com.dehalex.giphy.values.strings

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.dehalex.giphy.values.strings.translations.En

object AppStrings {

    var language by mutableStateOf<Language>(En())
        private set

    fun updateLanguage(language: Language) {
        this.language = language
    }

    operator fun invoke(): Language {
        return language
    }
}