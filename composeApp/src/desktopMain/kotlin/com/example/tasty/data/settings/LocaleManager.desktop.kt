package com.example.tasty.data.settings

import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import java.util.Locale

private val systemDefaultLocale: Locale = Locale.getDefault()

actual fun applyPlatformLanguage(languageCode: String) {
    val targetLocale = when (languageCode) {
        UserPreferences.LANG_EN -> Locale.forLanguageTag("en")
        UserPreferences.LANG_UK -> Locale.forLanguageTag("uk")
        else -> systemDefaultLocale
    }
    Locale.setDefault(targetLocale)
}

@Composable
actual fun ProvideAppLocale(
    languageCode: String,
    content: @Composable () -> Unit
) {
    applyPlatformLanguage(languageCode)
    key(languageCode) {
        content()
    }
}
