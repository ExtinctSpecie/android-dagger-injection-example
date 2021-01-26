package com.skarra.basetask.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.skarra.basetask.domain.model.GithubOwner
import javax.inject.Inject

internal class SecondaryActivityViewModelImpl @Inject constructor(
    githubOwner: GithubOwner
) : ViewModel(), SecondaryActivityViewModel {

    override val userName = MutableLiveData(githubOwner.id)
}