package com.skarra.basetask.data.repository

import com.skarra.basetask.app.mapper.ListMapper
import com.skarra.basetask.data.network.apiservice.GithubReposApiService
import com.skarra.basetask.data.network.model.GithubRepoResponse
import com.skarra.basetask.domain.model.GithubRepo
import com.skarra.basetask.domain.repository.GithubReposRepository
import io.reactivex.Single
import javax.inject.Inject

internal class GithubReposRepositoryImpl @Inject constructor(
    private val githubReposMapper: ListMapper<GithubRepoResponse, GithubRepo>,
    private val githubReposApiService: GithubReposApiService
) : GithubReposRepository {
    override fun getSquareRepos(): Single<List<GithubRepo>> {
        return githubReposApiService.getSquareGithubRepos().map {
            githubReposMapper.map(it)
        }
    }
}
