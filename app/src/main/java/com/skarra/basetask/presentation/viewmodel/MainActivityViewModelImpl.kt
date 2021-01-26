package com.skarra.basetask.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.skarra.basetask.domain.model.GithubRepo
import com.skarra.basetask.domain.usecase.GetSquareReposUseCase
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import javax.inject.Inject

internal class MainActivityViewModelImpl @Inject constructor(
    private val getSquareReposUseCase: GetSquareReposUseCase
) : ViewModel(), MainActivityViewModel {

    private val compositeDisposable = CompositeDisposable()
    override val githubRepos = MutableLiveData<List<GithubRepo>>()
    override val loading = MutableLiveData<Boolean>()

    override fun fetchSquareRepos() {
        getSquareReposUseCase()
            .doOnSubscribe {
                this.loading.value =  true
            }
            .doFinally {
                this.loading.postValue(false)
            }
            .subscribe({
                githubRepos.postValue(it)
            }, {

            })
            .addTo(compositeDisposable)
    }
}