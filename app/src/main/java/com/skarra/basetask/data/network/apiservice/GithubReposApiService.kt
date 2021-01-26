package com.skarra.basetask.data.network.apiservice

import com.skarra.basetask.data.network.model.GithubRepoResponse
import io.reactivex.Single

internal interface GithubReposApiService {
    fun getSquareGithubRepos(): Single<List<GithubRepoResponse>>
}