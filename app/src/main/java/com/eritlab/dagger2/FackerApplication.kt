package com.eritlab.dagger2

import android.app.Application
import com.eritlab.dagger2.di.ApplicationComponent
import com.eritlab.dagger2.di.DaggerApplicationComponent

class FackerApplication : Application() {
    lateinit var applicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder().build()
    }
}