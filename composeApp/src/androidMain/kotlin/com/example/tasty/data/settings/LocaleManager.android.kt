package com.example.tasty.data.settings

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.core.os.LocaleListCompat
import java.util.Locale

private val systemDefaultLocale: Locale = Locale.getDefault()

actual fun applyPlatformLanguage(languageCode: String) {
    val targetLocale = when (languageCode) {
        UserPreferences.LANG_EN -> Locale.forLanguageTag("en")
        UserPreferences.LANG_UK -> Locale.forLanguageTag("uk")
        else -> systemDefaultLocale
    }
    Locale.setDefault(targetLocale)

    val localeList = when (languageCode) {
        UserPreferences.LANG_EN -> LocaleListCompat.forLanguageTags("en")
        UserPreferences.LANG_UK -> LocaleListCompat.forLanguageTags("uk")
        else -> LocaleListCompat.getEmptyLocaleList()
    }
    AppCompatDelegate.setApplicationLocales(localeList)
}

@Composable
actual fun ProvideAppLocale(
    languageCode: String,
    content: @Composable () -> Unit
) {
    val baseContext = LocalContext.current
    val baseConfiguration = LocalConfiguration.current

    val targetLocale = remember(languageCode) {
        when (languageCode) {
            UserPreferences.LANG_EN -> Locale.forLanguageTag("en")
            UserPreferences.LANG_UK -> Locale.forLanguageTag("uk")
            else -> systemDefaultLocale
        }
    }

    val localizedConfiguration = remember(languageCode, baseConfiguration) {
        Locale.setDefault(targetLocale)
        Configuration(baseConfiguration).apply {
            setLocale(targetLocale)
        }
    }

    val localizedContext = remember(languageCode, baseContext) {
        baseContext.createConfigurationContext(localizedConfiguration)
    }

    CompositionLocalProvider(
        LocalConfiguration provides localizedConfiguration,
        LocalContext provides localizedContext
    ) {
        content()
    }
}
