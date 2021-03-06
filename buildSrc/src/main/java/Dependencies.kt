object ApplicationId {
    val id = "com.example.test_app"
}

object Modules {
    val app = ":app"

    val navigation = ":navigation"

    val common = ":common"

    val remote = ":data:remote"
    val model = ":data:model"
    val repository = ":data:repository"

    val featureHome = ":features:home"
    val featureGiftCardDetails = ":features:gift_card_details"

}

object Releases {
    val versionCode = 1
    val versionName = "1.0"
}

object Versions {
    val kotlin = "1.3.61"
    val gradle = "3.3.2"
    val compileSdk = 29
    val minSdk = 23
    val targetSdk = 29
    val appCompat = "1.1.0"
    val coreKtx = "1.1.0"
    val constraintLayout = "1.1.3"
    val retrofit = "2.5.0"
    val retrofitCoroutines = "0.9.2"
    val retrofitGson = "2.4.0"
    val gson = "2.8.5"
    val okHttp = "3.12.1"
    val coroutines = "1.1.1"
    val koin = "1.0.2"
    val lifecycle = "2.1.0-alpha04"
    val nav = "2.0.0"
    val recyclerview = "1.0.0"
    val safeArgs = "2.1.0-alpha01"
    val glide = "4.9.0"
    val spinKit = "1.2.0"

}

object Libraries {
    // KOIN
    val koin = "org.koin:koin-android:${Versions.koin}"
    val koinViewModel = "org.koin:koin-android-viewmodel:${Versions.koin}"
    // RETROFIT
    val retrofitCoroutineAdapter =
        "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.retrofitCoroutines}"
    val gson = "com.google.code.gson:gson:${Versions.gson}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofitGson}"
    val httpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
    // GLIDE
    val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    // SPIN KIT
    val spinKit = "com.github.ybq:Android-SpinKit:${Versions.spinKit}"

}

object KotlinLibraries {
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    val kotlinCoroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
}

object AndroidLibraries {
    // KOTLIN
    val kotlinCoroutineAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    // ANDROID
    val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    val navigation = "androidx.navigation:navigation-ui-ktx:${Versions.nav}"
    val navigationFrag = "androidx.navigation:navigation-fragment-ktx:${Versions.nav}"
}
