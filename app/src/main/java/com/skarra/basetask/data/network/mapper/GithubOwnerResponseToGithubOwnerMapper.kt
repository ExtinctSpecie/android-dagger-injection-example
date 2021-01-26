package com.skarra.basetask.data.network.mapper

import com.skarra.basetask.app.mapper.Mapper
import com.skarra.basetask.data.network.model.GithubOwnerResponse
import com.skarra.basetask.domain.model.GithubOwner
import javax.inject.Inject

internal class GithubOwnerResponseToGithubOwnerMapper @Inject constructor(

) : Mapper<GithubOwnerResponse?, GithubOwner> {

    override fun map(input: GithubOwnerResponse?): GithubOwner {
        return GithubOwner(
            input?.id.orEmpty(),
            input?.login.orEmpty(),
            input?.avatarUrl.orEmpty(),
            input?.url.orEmpty()
        )
    }
}