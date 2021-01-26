package com.skarra.basetask.data.network.mapper

import com.skarra.basetask.app.mapper.Mapper
import com.skarra.basetask.data.network.model.GithubOwnerResponse
import com.skarra.basetask.data.network.model.GithubRepoResponse
import com.skarra.basetask.domain.model.GithubOwner
import com.skarra.basetask.domain.model.GithubRepo
import javax.inject.Inject

internal class GithubRepoResponseToGithubRepoMapper @Inject constructor(
    private val ownerMapper: Mapper<GithubOwnerResponse?, GithubOwner>
): Mapper<GithubRepoResponse, GithubRepo> {
    override fun map(input: GithubRepoResponse): GithubRepo {
        return GithubRepo(
            input.id.orEmpty(),
            input.name.orEmpty(),
            input.fullName.orEmpty(),
            ownerMapper.map(input.owner),
            input.description.orEmpty()
        )
    }
}