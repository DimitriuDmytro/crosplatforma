package com.example.tasty.util.logging

import co.touchlab.kermit.Logger
import co.touchlab.kermit.Severity
import co.touchlab.kermit.loggerConfigInit
import co.touchlab.kermit.platformLogWriter

/**
 * Shared Koin-free logger wrapper built on Touchlab Kermit.
 * Logs application lifecycle, onboarding navigation, and user preference updates.
 */
object AppLogger {
    private val logger = Logger(
        config = loggerConfigInit(
            platformLogWriter(),
            minSeverity = Severity.Debug
        ),
        tag = "TastyApp"
    )

    fun d(tag: String = "TastyApp", message: () -> String) {
        logger.withTag(tag).d(message = message)
    }

    fun i(tag: String = "TastyApp", message: () -> String) {
        logger.withTag(tag).i(message = message)
    }

    fun w(tag: String = "TastyApp", throwable: Throwable? = null, message: () -> String) {
        logger.withTag(tag).w(throwable = throwable, message = message)
    }

    fun e(tag: String = "TastyApp", throwable: Throwable? = null, message: () -> String) {
        logger.withTag(tag).e(throwable = throwable, message = message)
    }

    fun logAppStart(onboardingCompleted: Boolean, language: String, themeMode: String) {
        i("Lifecycle") {
            "App started | onboardingCompleted=$onboardingCompleted, language=$language, themeMode=$themeMode"
        }
    }

    fun logOnboardingEvent(event: String) {
        i("Onboarding") { event }
    }

    fun logSettingsChange(settingName: String, newValue: String) {
        i("Settings") { "Preference updated: $settingName -> $newValue" }
    }
}
