package com.skarra.basetask.presentation.viewmodel

import androidx.lifecycle.LiveData
import com.skarra.basetask.domain.model.GithubRepo

internal interface MainActivityViewModel {
    val loading: LiveData<Boolean>
    val githubRepos: LiveData<List<GithubRepo>>

    fun fetchSquareRepos()
}