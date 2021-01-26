package com.skarra.basetask.app

import com.skarra.basetask.di.MainContributesModule
import dagger.Module


@Module(
    includes = [
        MainContributesModule::class
    ]
)
interface ContributesActivityModule