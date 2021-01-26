package com.skarra.basetask.presentation.router

import com.skarra.basetask.domain.model.GithubOwner
import com.skarra.basetask.presentation.view.MainActivity
import com.skarra.basetask.presentation.view.SecondaryActivity
import javax.inject.Inject

internal class MainActivityRouterImpl @Inject constructor(
    private val activity: MainActivity
) : MainActivityRouter {

    override fun goToSecondaryActivity() {
        val intent = SecondaryActivity.getStartIntent(
            activity, GithubOwner(
                "id",
                "login",
                "someImage.com",
                "profileUrl.com"
            )
        )
        activity.startActivity(intent)
    }
}