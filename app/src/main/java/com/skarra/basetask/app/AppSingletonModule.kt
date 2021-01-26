package com.skarra.basetask.app

import android.content.Context
import com.skarra.basetask.app.data.network.factory.network.RetrofitFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton


@Module()
object AppSingletonModule {

    @JvmStatic
    @Singleton
    @Provides
    fun provideApplicationContext(app: BaseApplication): Context {
        return app.applicationContext
    }

    @Provides
    @JvmStatic
    @Singleton
    @Named("github_orgs_api")
    fun providePunkRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        val client = okHttpClient.newBuilder()
            .build()

        return RetrofitFactory.createRetrofit(
            client,
            "https://api.github.com/orgs/"
        )
    }
}