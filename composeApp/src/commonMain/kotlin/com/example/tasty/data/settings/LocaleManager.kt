package com.example.tasty.data.settings

import androidx.compose.runtime.Composable

/**
 * Applies platform-specific locale override ("system", "en", "uk")
 * so that both platform APIs and Compose Multiplatform stringResource()
 * immediately resolve the selected language at runtime.
 */
expect fun applyPlatformLanguage(languageCode: String)

@Composable
expect fun ProvideAppLocale(
    languageCode: String,
    content: @Composable () -> Unit
)
