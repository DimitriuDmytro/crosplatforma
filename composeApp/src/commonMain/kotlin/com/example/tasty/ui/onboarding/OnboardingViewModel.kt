package com.example.tasty.ui.onboarding

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.LocalDining
import androidx.lifecycle.ViewModel
import com.example.tasty.data.settings.UserPreferences
import com.example.tasty.data.settings.applyPlatformLanguage
import com.example.tasty.util.logging.AppLogger
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import tasty.composeapp.generated.resources.Res
import tasty.composeapp.generated.resources.onboarding_desc_1
import tasty.composeapp.generated.resources.onboarding_desc_2
import tasty.composeapp.generated.resources.onboarding_desc_3
import tasty.composeapp.generated.resources.onboarding_desc_4
import tasty.composeapp.generated.resources.onboarding_title_1
import tasty.composeapp.generated.resources.onboarding_title_2
import tasty.composeapp.generated.resources.onboarding_title_3
import tasty.composeapp.generated.resources.onboarding_title_4

data class OnboardingUiState(
    val currentPage: Int = 0,
    val isOnboardingCompleted: Boolean = false,
    val language: String = UserPreferences.LANG_SYSTEM,
    val themeMode: String = UserPreferences.THEME_SYSTEM
)

class OnboardingViewModel(
    private val preferences: UserPreferences = UserPreferences()
) : ViewModel() {

    val pages: List<OnboardingPage> = listOf(
        OnboardingPage(
            titleRes = Res.string.onboarding_title_1,
            descriptionRes = Res.string.onboarding_desc_1,
            icon = Icons.AutoMirrored.Filled.MenuBook
        ),
        OnboardingPage(
            titleRes = Res.string.onboarding_title_2,
            descriptionRes = Res.string.onboarding_desc_2,
            icon = Icons.Default.FilterList
        ),
        OnboardingPage(
            titleRes = Res.string.onboarding_title_3,
            descriptionRes = Res.string.onboarding_desc_3,
            icon = Icons.Default.LocalDining
        ),
        OnboardingPage(
            titleRes = Res.string.onboarding_title_4,
            descriptionRes = Res.string.onboarding_desc_4,
            icon = Icons.Default.BookmarkBorder
        )
    )

    private val _uiState = MutableStateFlow(
        OnboardingUiState(
            currentPage = 0,
            isOnboardingCompleted = preferences.onboardingCompleted,
            language = preferences.language,
            themeMode = preferences.themeMode
        )
    )
    val uiState: StateFlow<OnboardingUiState> = _uiState.asStateFlow()

    init {
        val state = _uiState.value
        applyPlatformLanguage(state.language)
        AppLogger.logAppStart(
            onboardingCompleted = state.isOnboardingCompleted,
            language = state.language,
            themeMode = state.themeMode
        )
    }

    fun onPageChanged(page: Int) {
        if (_uiState.value.currentPage != page) {
            _uiState.update { it.copy(currentPage = page) }
            AppLogger.logOnboardingEvent("Swiped/navigated to onboarding slide ${page + 1} of ${pages.size}")
        }
    }

    fun onNextClicked(currentPage: Int) {
        AppLogger.logOnboardingEvent("Next button clicked on slide ${currentPage + 1}")
    }

    fun completeOnboarding(source: String) {
        AppLogger.logOnboardingEvent("Onboarding completed via '$source'")
        preferences.onboardingCompleted = true
        _uiState.update { it.copy(isOnboardingCompleted = true) }
    }

    fun resetOnboarding() {
        AppLogger.logOnboardingEvent("Onboarding reset requested from Home screen")
        preferences.onboardingCompleted = false
        _uiState.update {
            it.copy(
                currentPage = 0,
                isOnboardingCompleted = false
            )
        }
    }

    fun setLanguage(languageCode: String) {
        if (_uiState.value.language != languageCode) {
            preferences.language = languageCode
            applyPlatformLanguage(languageCode)
            _uiState.update { it.copy(language = languageCode) }
        }
    }

    fun setThemeMode(themeMode: String) {
        if (_uiState.value.themeMode != themeMode) {
            preferences.themeMode = themeMode
            _uiState.update { it.copy(themeMode = themeMode) }
        }
    }
}
