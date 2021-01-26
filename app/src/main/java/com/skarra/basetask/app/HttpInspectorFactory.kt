package com.skarra.basetask.app

import android.content.Context
import com.ashokvarma.gander.Gander
import com.ashokvarma.gander.GanderInterceptor
import com.ashokvarma.gander.imdb.GanderIMDB
import okhttp3.Interceptor

class HttpInspectorFactory(private val context: Context) {

    init {
        Gander.setGanderStorage(GanderIMDB.getInstance())
    }

    fun createInterceptor(): Interceptor {
        return GanderInterceptor(context).showNotification(true)
    }

}