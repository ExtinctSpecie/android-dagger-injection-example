package com.skarra.basetask.di

import com.skarra.basetask.app.PerFragment
import com.skarra.basetask.app.domain.viewmodel.factory.getViewModel
import com.skarra.basetask.domain.model.GithubOwner
import com.skarra.basetask.presentation.router.MainActivityRouter
import com.skarra.basetask.presentation.router.MainActivityRouterImpl
import com.skarra.basetask.presentation.router.SecondaryActivityRouter
import com.skarra.basetask.presentation.router.SecondaryActivityRouterImpl
import com.skarra.basetask.presentation.view.FooFragment
import com.skarra.basetask.presentation.view.SecondaryActivity
import com.skarra.basetask.presentation.viewmodel.SecondaryActivityViewModel
import com.skarra.basetask.presentation.viewmodel.SecondaryActivityViewModelImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import javax.inject.Provider


@Module(
    includes = [
        SecondaryActivityModule.ProvidesModule::class,
        SecondaryActivityModule.BindsModule::class
    ]
)
internal interface SecondaryActivityModule {

    @PerFragment
    @ContributesAndroidInjector(modules = [FooFragmentModule::class])
    fun contributesFooFragment(): FooFragment

    @Module
    interface BindsModule {
        @Binds
        fun bindsSecondaryActivityRouter(router: SecondaryActivityRouterImpl): SecondaryActivityRouter
    }

    @Module
    object ProvidesModule {

        @JvmStatic
        @Provides
        fun providesGithubOwner(activity: SecondaryActivity): GithubOwner {
            return activity.githubOwner
        }

        @JvmStatic
        @Provides
        fun providesSecondaryActivityViewModel(
            viewModelProvider: Provider<SecondaryActivityViewModelImpl>,
            activity: SecondaryActivity
        ): SecondaryActivityViewModel {
            return activity.getViewModel { viewModelProvider.get() }
        }

    }
}