package com.skarra.basetask.data.network.model

import com.google.gson.annotations.SerializedName

internal data class GithubRepoResponse(
    val id: String?,
    val name: String?,
    @SerializedName("full_name")
    val fullName: String?,
    val owner: GithubOwnerResponse?,
    val description: String?
)