package com.example.tasty.ui.onboarding

import androidx.compose.ui.graphics.vector.ImageVector
import org.jetbrains.compose.resources.StringResource

data class OnboardingPage(
    val titleRes: StringResource,
    val descriptionRes: StringResource,
    val icon: ImageVector
)
