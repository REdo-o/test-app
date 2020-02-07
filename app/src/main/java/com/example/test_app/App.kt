package com.example.test_app

import android.app.Application
import com.example.test_app.di.appComponent
import org.koin.android.ext.android.startKoin

open class App : Application() {


    override fun onCreate() {
        super.onCreate()
        configureDi()
    }

    // CONFIGURATION ---
    open fun configureDi() =
        startKoin(this, provideComponent())

    // PUBLIC API ---
    open fun provideComponent() = appComponent
}