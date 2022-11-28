package com.eritlab.dagger2.di

import com.eritlab.dagger2.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)
}