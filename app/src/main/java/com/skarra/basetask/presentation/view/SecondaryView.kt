package com.skarra.basetask.presentation.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.skarra.basetask.R
import com.skarra.basetask.presentation.router.SecondaryActivityRouter
import com.skarra.basetask.presentation.viewmodel.SecondaryActivityViewModel
import javax.inject.Inject

internal class SecondaryView @Inject constructor(
    private val router: SecondaryActivityRouter,
    private val viewModel: SecondaryActivityViewModel
) {

    fun inflate(
        inflater: LayoutInflater,
        container: ViewGroup?,
        lifecycleOwner: LifecycleOwner
    ): View {
        val view = inflater.inflate(R.layout.activity_secondary, container)
        setupClickListeners(view)
        observeViewModel(view, lifecycleOwner)
        return view
    }

    private fun setupClickListeners(view: View) {
        view.findViewById<Toolbar>(R.id.secondary_activity_tb).apply {
            setNavigationOnClickListener {
                router.goBack()
            }
        }
    }

    private fun observeViewModel(view: View, lifecycleOwner: LifecycleOwner){
        viewModel.userName.observe(lifecycleOwner, Observer {
            Toast.makeText(view.context, it, Toast.LENGTH_LONG).show()
        })
    }
}