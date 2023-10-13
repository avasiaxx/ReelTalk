# Reel Talk Android Developer Intern Challenge

## Introduction

Reel Talk Android Developer Intern Challenge is an Android application designed for [brief description of the app's purpose]. This README provides an overview of the project's Gradle setup.

## Gradle Configuration

This Android project is configured with Gradle build scripts that handle the project's dependencies, Android SDK version, and more. Below, you'll find key information about the Gradle configuration.

### App Namespace

The app uses the following namespace:

```gradle
android {
    namespace = "com.avasia.reeltalk"
}
```

## Android SDK Version
The project targets Android SDK version 34 and has a minimum SDK version of 26.

```gradle
android {
    compileSdk = 34
    defaultConfig {
        minSdk = 26
        targetSdk = 34
    }
}
```

## Default Configuration
The default configuration includes the application ID, version information, and test instrumentation runner. The application ID and version details can be modified according to your app's requirements.
```gradle
defaultConfig {
    applicationId = "com.avasia.reeltalk"
    versionCode = 1
    versionName = "1.0"
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
}
```

## Build Features
ViewBinding is enabled for this project.
```gradle
android {
    buildFeatures {
        viewBinding = true
    }
}
```

## Build Types
The release build type is configured to disable minification (proguard).
```gradle
android {
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}
```

## Compile and Kotlin Options
The project's compile and Kotlin options are configured as follows:
```gradle
android {
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}
```
## Dependencies
The project includes various dependencies, including AndroidX libraries, testing frameworks, Android Navigation components, ViewPager2, Dot Indicator, and Circle Image View.

Implementation Dependencies
```gradle
dependencies {
    implementation lib.dependencies.core.ktx
    implementation lib.dependencies.appcompat
    implementation lib.dependencies.material
    implementation lib.dependencies.constraintlayout
    implementation lib.dependencies.navigation.fragment
    implementation lib.dependencies.navigation.ui
    implementation lib.dependencies.viewpager2
    implementation lib.dependencies.dotsindicator
    implementation lib.dependencies.circleimageview
}
```

## Getting Started
To get started with Reel Talk Android Developer Intern Challenge, follow these steps:

Clone or download the project from the repository URL.
Open the project in Android Studio or your preferred Android development environment.
Build and run the app on an Android emulator or a physical device.
Explore the app and start developing your features!

