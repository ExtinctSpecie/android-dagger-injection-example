package com.skarra.basetask.data.network.model

import com.google.gson.annotations.SerializedName

internal data class GithubOwnerResponse(
    val id: String?,
    val login: String?,
    @SerializedName("avatar_url")
    val avatarUrl: String?,
    val url: String?
)