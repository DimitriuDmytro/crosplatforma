# Tasty — Kotlin Multiplatform Recipes App (Lab 1)

**Tasty** is a Kotlin Multiplatform (KMP) application built with **Compose Multiplatform** targeting **Android**, **iOS**, and **Desktop (JVM)**. This repository contains the foundation for a full REST API client in the **Recipes** domain.

---

## Domain & Target API

- **Domain**: Culinary Recipes (`RECIPES`)
- **REST API Endpoint**: [`https://dummyjson.com/recipes`](https://dummyjson.com/recipes)
- **Current Scope**: Project architecture, Material 3 custom theming, custom Google Fonts typography, structured logging with **Kermit**, persistent preferences with **multiplatform-settings**, a 4-slide **HorizontalPager** onboarding flow, and runtime **English / Ukrainian** localization. *(Networking will be added in the next lab).*

---

## Implemented Lab Items

1. **Kotlin Multiplatform & Compose Multiplatform Setup (`com.example.tasty`)**
   - Single shared `:composeApp` module targeting Android, iOS (`iosX64`, `iosArm64`, `iosSimulatorArm64`), and Desktop (`jvm("desktop")`).
   - Managed via a Gradle Version Catalog (`gradle/libs.versions.toml`).
2. **Custom Material 3 Theme (`ui/theme`)**
   - **Color Palette (`Color.kt`)**:
     - Primary: `#E8590C` | Secondary: `#2F6B3F`
     - Light Background: `#FFF8F1` | Dark Background: `#1C1410`
     - Light Surface: `#FFFFFF` | Dark Surface: `#261C16`
     - OnBackground (Light): `#2B2118`
   - **Typography (`Type.kt`)**: Bundled Google Fonts `.ttf` files in `composeResources/font` — **Poppins** (`Regular`, `SemiBold`, `Bold`) for display/headline/title styles and **Inter** (`Regular`, `Medium`, `SemiBold`) for body/label styles.
   - **Shapes (`Shape.kt`)**: `16.dp` rounded corners for medium/large Material 3 shapes.
   - **Theme (`Theme.kt`)**: `AppTheme` supporting `"system"`, `"light"`, and `"dark"` modes.
3. **Logging & Persistent User Preferences**
   - **Kermit (`util/logging/AppLogger.kt`)**: Shared Koin-free logger (`co.touchlab:kermit`) logging application startup state, onboarding slide navigation/actions, and user preference mutations.
   - **Multiplatform Settings (`data/settings/UserPreferences.kt`)**: Backed by `com.russhwolf:multiplatform-settings` and `multiplatform-settings-no-arg`, persisting:
     - `onboardingCompleted: Boolean`
     - `language: String` (`"system"` / `"uk"` / `"en"`)
     - `themeMode: String` (`"system"` / `"light"` / `"dark"`)
4. **Onboarding Screen & ViewModel (`ui/onboarding`, `ui/home`)**
   - 4-slide `HorizontalPager` with Material icons, animated indicator dots, **Skip** button, and **Next** button that transitions to **Get Started** on the final slide (`animateScrollToPage` via coroutine scope).
   - State managed by `OnboardingViewModel` (`androidx.lifecycle.ViewModel`).
   - Conditional start destination: displays `OnboardingScreen` on first launch and transitions to `HomeScreen` once completed. `HomeScreen` includes language & theme switchers and a **Reset Onboarding** button.
5. **Multiplatform Localization (`composeResources/values` & `values-uk`)**
   - All user-visible strings externalized in XML resources (`strings.xml`).
   - Runtime locale switching persisted in `UserPreferences` and applied via `expect`/`actual` (`LocaleManager.kt`).

---

## Localization

All user-facing text is stored in Compose Multiplatform resources:
- **English (Default)**: `composeApp/src/commonMain/composeResources/values/strings.xml`
- **Ukrainian (`uk`)**: `composeApp/src/commonMain/composeResources/values-uk/strings.xml`

### Runtime Language Switching (`expect` / `actual`)
When the user selects `"system"`, `"en"`, or `"uk"` on the Home screen:
1. `UserPreferences` persists the selection via `multiplatform-settings` and logs the change via `AppLogger`.
2. Platform-specific `applyPlatformLanguage(languageCode)` and `@Composable ProvideAppLocale(languageCode)` update the active locale immediately without requiring an app restart:
   - **Android (`LocaleManager.android.kt`)**: Updates `Locale.setDefault(...)`, calls `AppCompatDelegate.setApplicationLocales(...)`, and provides a localized `Configuration` and `Context` via `CompositionLocalProvider(LocalConfiguration, LocalContext)`.
   - **iOS (`LocaleManager.ios.kt`)**: Updates `NSUserDefaults.standardUserDefaults` (`AppleLanguages` key) and triggers recomposition of Compose resources via `key(languageCode)`.
   - **Desktop (`LocaleManager.desktop.kt`)**: Updates `Locale.setDefault(...)` and triggers recomposition via `key(languageCode)`.

---

## Screenshots

| Onboarding (English) | Onboarding (Ukrainian) | Home Screen (Light) | Home Screen (Dark) |
| :---: | :---: | :---: | :---: |
| ![Onboarding EN](docs/screenshots/onboarding_en.png) | ![Onboarding UK](docs/screenshots/onboarding_uk.png) | ![Home Light](docs/screenshots/home_light.png) | ![Home Dark](docs/screenshots/home_dark.png) |

*(Placeholders for lab report screenshots)*

---

## How to Build & Run

### 1. Android
Build the debug APK from the terminal:
```bash
./gradlew :composeApp:assembleDebug
```
The generated APK will be located at `composeApp/build/outputs/apk/debug/composeApp-debug.apk`.
To install and launch on a connected device or emulator:
```bash
./gradlew :composeApp:installDebug
```

### 2. Desktop (JVM)
Run the Desktop application directly via Gradle:
```bash
./gradlew :composeApp:run
```

### 3. iOS (macOS with Xcode)
Open the `iosApp` directory in Xcode or build the Kotlin framework via Gradle:
```bash
./gradlew :composeApp:assembleXCFramework
```
