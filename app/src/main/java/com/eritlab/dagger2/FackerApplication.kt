package com.eritlab.dagger2

import android.app.Application
import com.eritlab.dagger2.di.ApplicationComponent
import com.eritlab.dagger2.di.DaggerApplicationComponent
import com.google.android.material.color.DynamicColors

class FackerApplication : Application() {
    lateinit var applicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        DynamicColors.applyToActivitiesIfAvailable(this);
        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }
}