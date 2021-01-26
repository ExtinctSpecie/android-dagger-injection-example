package com.skarra.basetask.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.skarra.basetask.R
import dagger.android.AndroidInjection
import javax.inject.Inject

internal class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var view: MainView

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(view.inflate(layoutInflater, null, this))
    }
}