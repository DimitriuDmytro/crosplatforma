package com.example.tasty.data.settings

import com.example.tasty.util.logging.AppLogger
import com.russhwolf.settings.Settings

/**
 * Manages persisted user preferences using multiplatform-settings (no-arg Settings()).
 *
 * Properties:
 * - onboardingCompleted: Boolean (default false)
 * - language: String ("system" / "uk" / "en", default "system")
 * - themeMode: String ("system" / "light" / "dark", default "system")
 */
class UserPreferences(
    private val settings: Settings = Settings()
) {
    companion object {
        private const val KEY_ONBOARDING_COMPLETED = "onboarding_completed"
        private const val KEY_LANGUAGE = "language"
        private const val KEY_THEME_MODE = "theme_mode"

        const val LANG_SYSTEM = "system"
        const val LANG_EN = "en"
        const val LANG_UK = "uk"

        const val THEME_SYSTEM = "system"
        const val THEME_LIGHT = "light"
        const val THEME_DARK = "dark"
    }

    var onboardingCompleted: Boolean
        get() = settings.getBoolean(KEY_ONBOARDING_COMPLETED, false)
        set(value) {
            settings.putBoolean(KEY_ONBOARDING_COMPLETED, value)
            AppLogger.logSettingsChange(KEY_ONBOARDING_COMPLETED, value.toString())
        }

    var language: String
        get() = settings.getString(KEY_LANGUAGE, LANG_SYSTEM)
        set(value) {
            settings.putString(KEY_LANGUAGE, value)
            AppLogger.logSettingsChange(KEY_LANGUAGE, value)
        }

    var themeMode: String
        get() = settings.getString(KEY_THEME_MODE, THEME_SYSTEM)
        set(value) {
            settings.putString(KEY_THEME_MODE, value)
            AppLogger.logSettingsChange(KEY_THEME_MODE, value)
        }
}
