[Reel Talk Android Developer Intern Challenge]
Introduction
[Reel Talk Android Developer Intern Challenge] is an Android application designed for [a potential intern position for Reel Talk]. This README provides an overview of the project's Gradle setup.

Gradle Configuration
This Android project is configured with Gradle build scripts that handle the project's dependencies, Android SDK version, and more. Below, you'll find key information about the Gradle configuration.

App Namespace
The app uses the following namespace:

java
Copy code
namespace = "com.avasia.reeltalk"
Android SDK Version
The project targets Android SDK version 34 and has a minimum SDK version of 26.

java
Copy code
compileSdk = 34
minSdk = 26
targetSdk = 34
Default Configuration
The default configuration includes the application ID, version information, and test instrumentation runner. The application ID and version details can be modified according to your app's requirements.

java
Copy code
applicationId = "com.avasia.reeltalk"
versionCode = 1
versionName = "1.0"
testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
Build Features
ViewBinding is enabled for this project.

java
Copy code
buildFeatures {
    viewBinding = true
}
Build Types
The release build type is configured to disable minification (proguard).

java
Copy code
release {
    isMinifyEnabled = false
    proguardFiles(
        getDefaultProguardFile("proguard-android-optimize.txt"),
        "proguard-rules.pro"
    )
}
Compile and Kotlin Options
The project's compile and Kotlin options are configured as follows:

java
Copy code
compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

kotlinOptions {
    jvmTarget = "1.8"
}
Dependencies
The project includes various dependencies, including AndroidX libraries, testing frameworks, Android Navigation components, ViewPager2, Dot Indicator, and Circle Image View.

Implementation Dependencies
java
Copy code
implementation(libs.core.ktx)
implementation(libs.appcompat)
implementation(libs.material)
implementation(libs.constraintlayout)
implementation(libs.navigation.fragment)
implementation(libs.navigation.ui)
implementation(libs.viewpager2)
implementation(libs.dotsindicator)
implementation(libs.circleimageview)
Testing Dependencies
java
Copy code
testImplementation(libs.junit)
androidTestImplementation(libs.androidx.test.ext.junit)
androidTestImplementation(libs.espresso.core)
Getting Started
To get started with [Reel Talk Android Developer Intern Challenge], follow these steps:

Clone or download the project from the repository URL.
Open the project in Android Studio or your preferred Android development environment.
Build and run the app on an Android emulator or a physical device.
Explore the app and start developing your features!
