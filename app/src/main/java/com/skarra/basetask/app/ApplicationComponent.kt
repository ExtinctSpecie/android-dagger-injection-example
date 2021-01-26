package com.skarra.basetask.app

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ConfigurationModule::class,
        AppSingletonModule::class,
        ContributesActivityModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(appApplication: BaseApplication): Builder

        fun build(): ApplicationComponent
    }
}