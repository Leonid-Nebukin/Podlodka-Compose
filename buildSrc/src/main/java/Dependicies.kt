object Dependicies {
    object Android {
        const val appCompat = "androidx.appcompat:appcompat:1.4.0"
        const val material = "com.google.android.material:material:1.4.0"
        const val core = "androidx.core:core-ktx:1.7.0"
    }

    object Compose {
        const val composeVersion = "1.0.2"
        const val ui = "androidx.compose.ui:ui:$composeVersion"
        const val material = "androidx.compose.material:material:$composeVersion"
        const val preview = "androidx.compose.ui:ui-tooling-preview:$composeVersion"
        const val tooling = "androidx.compose.ui:ui-tooling:$composeVersion"
        const val activity = "androidx.activity:activity-compose:1.4.0"
        const val systemUI = "com.google.accompanist:accompanist-systemuicontroller:0.17.0"
        const val inset = "com.google.accompanist:accompanist-insets:0.24.2-alpha"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout-compose:1.0.0"
        const val ratingBar = "io.github.a914-gowtham:compose-ratingbar:1.2.3"
    }

    const val gradle = "com.android.tools.build:gradle:7.0.4"

    object Kotlin {
        private const val kotlinVersion = "1.5.31"
        const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlinVersion"
        const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21"
        const val kotlinReflect = "org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion"
    }
}