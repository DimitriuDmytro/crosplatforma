package com.example.tasty

import androidx.compose.animation.Crossfade
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tasty.data.settings.ProvideAppLocale
import com.example.tasty.ui.home.HomeScreen
import com.example.tasty.ui.onboarding.OnboardingScreen
import com.example.tasty.ui.onboarding.OnboardingViewModel
import com.example.tasty.ui.theme.AppTheme

@Composable
fun App(
    onboardingViewModel: OnboardingViewModel = viewModel { OnboardingViewModel() }
) {
    val uiState by onboardingViewModel.uiState.collectAsState()

    ProvideAppLocale(languageCode = uiState.language) {
        AppTheme(themeMode = uiState.themeMode) {
            Crossfade(targetState = uiState.isOnboardingCompleted) { completed ->
                if (!completed) {
                    OnboardingScreen(
                        pages = onboardingViewModel.pages,
                        onPageChanged = onboardingViewModel::onPageChanged,
                        onNextClicked = onboardingViewModel::onNextClicked,
                        onFinish = onboardingViewModel::completeOnboarding
                    )
                } else {
                    HomeScreen(
                        currentLanguage = uiState.language,
                        currentThemeMode = uiState.themeMode,
                        onLanguageSelected = onboardingViewModel::setLanguage,
                        onThemeModeSelected = onboardingViewModel::setThemeMode,
                        onResetOnboarding = onboardingViewModel::resetOnboarding
                    )
                }
            }
        }
    }
}
