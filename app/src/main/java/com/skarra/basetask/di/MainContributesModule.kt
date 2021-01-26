package com.skarra.basetask.di

import com.skarra.basetask.app.PerActivity
import com.skarra.basetask.app.PerFragment
import com.skarra.basetask.presentation.view.FooFragment
import com.skarra.basetask.presentation.view.MainActivity
import com.skarra.basetask.presentation.view.SecondaryActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal interface MainContributesModule{

    @PerActivity
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    fun contributesMainActivity(): MainActivity

    @PerActivity
    @ContributesAndroidInjector(modules = [SecondaryActivityModule::class])
    fun contributesSecondaryActivity(): SecondaryActivity
}