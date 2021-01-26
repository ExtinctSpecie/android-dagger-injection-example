package com.skarra.basetask.presentation.router

import com.skarra.basetask.presentation.view.SecondaryActivity
import javax.inject.Inject

internal class SecondaryActivityRouterImpl @Inject constructor(
    private val activity: SecondaryActivity
) : SecondaryActivityRouter {
    override fun goBack() {
        activity.finish()
    }
}