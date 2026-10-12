package com.example.tasty.data.settings

import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import platform.Foundation.NSUserDefaults

actual fun applyPlatformLanguage(languageCode: String) {
    val defaults = NSUserDefaults.standardUserDefaults
    when (languageCode) {
        UserPreferences.LANG_EN, UserPreferences.LANG_UK -> {
            defaults.setObject(listOf(languageCode), forKey = "AppleLanguages")
        }
        else -> {
            defaults.removeObjectForKey("AppleLanguages")
        }
    }
    defaults.synchronize()
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
