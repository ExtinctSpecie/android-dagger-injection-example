package com.skarra.basetask.domain.usecase

import com.skarra.basetask.domain.model.GithubRepo
import io.reactivex.Single

internal interface GetSquareReposUseCase{
    operator fun invoke(): Single<List<GithubRepo>>
}