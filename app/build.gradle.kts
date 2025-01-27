plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.bill_d00r.gifsviewer"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.bill_d00r.gifsviewer"
        minSdk = 28
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
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
}

dependencies {

    implementation ("androidx.core:core-ktx:1.7.0")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    implementation ("androidx.activity:activity-compose:1.3.1")
    val composeUiVersion = "1.7.6"
    implementation ("androidx.compose.ui:ui:$composeUiVersion")
    implementation ("androidx.compose.ui:ui-tooling-preview:$composeUiVersion")
    implementation ("androidx.compose.material:material:1.2.0")
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:$composeUiVersion")
    debugImplementation ("androidx.compose.ui:ui-tooling:$composeUiVersion")
    debugImplementation ("androidx.compose.ui:ui-test-manifest:$composeUiVersion")

    implementation(libs.navigation.compose)
    implementation(libs.kotlinx.serialization.json)

    // Coil Compose
    implementation ("io.coil-kt:coil-compose:2.2.2")
    implementation("io.coil-kt:coil-gif:2.2.2")
    implementation ("androidx.lifecycle:lifecycle-runtime-compose:2.6.1")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")

    // Dagger - Hilt
    implementation ("com.google.dagger:hilt-android:2.51.1")
    kapt ("com.google.dagger:hilt-android-compiler:2.51.1")
    kapt ("androidx.hilt:hilt-compiler:1.2.0")
    implementation ("androidx.hilt:hilt-navigation-compose:1.2.0")

    // Paging
    implementation ("androidx.paging:paging-runtime-ktx:3.1.1")
    implementation ("androidx.paging:paging-compose:1.0.0-alpha18")

    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-moshi:2.9.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.3")

    //Moshi
    val moshi_version = "1.15.2"
    kapt("com.squareup.moshi:moshi-kotlin-codegen:$moshi_version")
    implementation ("com.squareup.moshi:moshi:$moshi_version")
    implementation ("com.squareup.moshi:moshi-adapters:$moshi_version")
    implementation ("com.squareup.moshi:moshi-kotlin:$moshi_version")

    // Room
    implementation ("androidx.room:room-ktx:2.5.1")
    kapt ("androidx.room:room-compiler:2.5.1")
    implementation ("androidx.room:room-paging:2.5.1")

    implementation("com.github.bumptech.glide:glide:4.14.2")
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}