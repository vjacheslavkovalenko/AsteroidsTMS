plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.serialization)
//    alias(libs.plugins.navigation.safeargs)
    alias(libs.plugins.room)
    alias(libs.plugins.kotlin.parcelize)
//    alias(libs.plugins.ksp)
//    alias(libs.plugins.kotlin.kapt)
//    kotlin("kapt")
//    id ("kotlin-kapt")
    id("com.google.devtools.ksp")
}

android {
    namespace = "by.vjacheslavkovalenko.asteroidstms"
    compileSdk = 35

    defaultConfig {
        applicationId = "by.vjacheslavkovalenko.asteroidstms"
        minSdk = 26
        //noinspection OldTargetApi
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        viewBinding = true
    }

    room {
        schemaDirectory("$projectDir/schemas")
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.lottie)
    implementation(libs.dagger.hilt.android)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)
    implementation(libs.okhttp)
    implementation(libs.okhttp.loggingInterceptor)
//    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")
    implementation(libs.gson)
    implementation(libs.glide)
    implementation(libs.paging)
    implementation(libs.room)
    implementation(libs.room.runtime)
    implementation(libs.room.paging)
    implementation(libs.androidx.baselibrary)
    annotationProcessor(libs.room.compiler)
//    ksp(libs.room.compiler)
//    kapt(libs.)
//    kapt (libs.hilt.compiler)
//    kapt ("com.google.dagger:hilt-compiler:2.49")
    //plugins {
    //    alias(libs.plugins.androidApplication) apply false
    //    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    //    id 'com.google.dagger.hilt.android' version '2.49' apply false
    //}
    //——
    //plugins {
    //    alias(libs.plugins.androidApplication)
    //    alias(libs.plugins.jetbrainsKotlinAndroid)
    //    id 'kotlin-kapt'
    //    id 'com.google.dagger.hilt.android'
    //}
    //
    //
    //    implementation "com.google.dagger:hilt-android:2.49"
    //    kapt "com.google.dagger:hilt-compiler:2.49"
    //
    //    implementation 'androidx.fragment:fragment-ktx:1.8.1'
    ksp("androidx.room:room-compiler:2.5.0")
    implementation ("com.google.dagger:hilt-android:2.49")

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
