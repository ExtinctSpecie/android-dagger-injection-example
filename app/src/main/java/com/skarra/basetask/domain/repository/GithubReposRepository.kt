package com.skarra.basetask.domain.repository

import com.skarra.basetask.domain.model.GithubRepo
import io.reactivex.Single


internal interface GithubReposRepository {

    fun getSquareRepos(): Single<List<GithubRepo>>
}
