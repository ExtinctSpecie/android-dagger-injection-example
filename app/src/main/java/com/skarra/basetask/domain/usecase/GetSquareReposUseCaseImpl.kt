package com.skarra.basetask.domain.usecase

import com.skarra.basetask.domain.repository.GithubReposRepository
import com.skarra.basetask.domain.model.GithubRepo
import io.reactivex.Single
import javax.inject.Inject

internal class GetSquareReposUseCaseImpl @Inject constructor(
            private val repository: GithubReposRepository
): GetSquareReposUseCase{
    override fun invoke(): Single<List<GithubRepo>> {
        return repository.getSquareRepos()
    }

}