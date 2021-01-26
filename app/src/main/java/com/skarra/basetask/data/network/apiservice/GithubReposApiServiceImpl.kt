package com.skarra.basetask.data.network.apiservice

import com.skarra.basetask.data.network.api.GithubReposApi
import com.skarra.basetask.data.network.model.GithubRepoResponse
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

internal class GithubReposApiServiceImpl @Inject constructor(
    private val api: GithubReposApi
) : GithubReposApiService {
    override fun getSquareGithubRepos(): Single<List<GithubRepoResponse>> {
        return api.getSquareRepos().subscribeOn(Schedulers.io())
    }
}