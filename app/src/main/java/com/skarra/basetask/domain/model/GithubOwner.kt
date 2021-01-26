package com.skarra.basetask.domain.model

import java.io.Serializable

internal data class GithubOwner(
    val id: String,
    val login: String,
    val avatarUrl: String,
    val url: String?
): Serializable