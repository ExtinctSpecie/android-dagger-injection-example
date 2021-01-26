package com.skarra.basetask.app

import android.content.Context
import com.moczul.ok2curl.CurlInterceptor
import com.skarra.basetask.BuildConfig
import com.skarra.basetask.app.annotations.Loggable
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber
import javax.inject.Singleton


@Module
object ConfigurationModule {

    @JvmStatic
    @Provides
    @Singleton
    fun provideOkHttpClient(context: Context, @Loggable debug: Boolean): OkHttpClient {
        val interceptor = HttpInspectorFactory(context).createInterceptor()
        val builder: OkHttpClient.Builder = OkHttpClient.Builder()
        builder.addInterceptor(interceptor)
        if (debug) {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC

            builder.addInterceptor(httpLoggingInterceptor)
            builder.addNetworkInterceptor(CurlInterceptor { message -> Timber.d(message) })
        }
        return builder.build()
    }

    @Provides
    @Singleton
    @Loggable
    fun provideDebugConfig(): Boolean {
        return BuildConfig.DEBUG
    }
}