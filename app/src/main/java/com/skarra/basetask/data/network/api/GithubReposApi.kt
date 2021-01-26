package com.skarra.basetask.data.network.api

import com.skarra.basetask.data.network.model.GithubRepoResponse
import io.reactivex.Single
import retrofit2.http.GET

internal interface GithubReposApi  {

    @GET("square/repos")
    fun  getSquareRepos(): Single<List<GithubRepoResponse>>
}