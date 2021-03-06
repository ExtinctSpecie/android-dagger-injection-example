package com.skarra.basetask.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.skarra.basetask.R
import com.skarra.basetask.presentation.viewmodel.SecondaryActivityViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

internal class FooFragment : Fragment() {

    @Inject
    lateinit var secondaryActivityViewModel: SecondaryActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_foo, container, false)
    }
}