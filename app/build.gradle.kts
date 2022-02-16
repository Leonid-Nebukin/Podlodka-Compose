plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdk = 31

    defaultConfig {
        applicationId = "com.example.podlodkaComposeDota2"
        minSdk = 23
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"


        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Dependicies.Compose.composeVersion
    }
    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {

    implementation(Dependicies.Android.core)
    implementation(Dependicies.Android.appCompat)
    implementation(Dependicies.Android.material)

    //Compose
    implementation(Dependicies.Compose.ui)
    implementation(Dependicies.Compose.material)
    implementation(Dependicies.Compose.preview)
    implementation(Dependicies.Compose.activity)
    implementation(Dependicies.Compose.systemUI)
    implementation(Dependicies.Compose.inset)
    implementation(Dependicies.Compose.constraintLayout)
    implementation(Dependicies.Compose.ratingBar)
    debugImplementation(Dependicies.Compose.tooling)
}