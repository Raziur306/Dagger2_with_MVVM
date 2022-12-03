package com.eritlab.dagger2.di

import androidx.lifecycle.ViewModel
import com.eritlab.dagger2.viewModel.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @ClassKey(MainViewModel::class)
    @IntoMap
    abstract fun getMainViewModel(mainViewModel: MainViewModel): ViewModel

}