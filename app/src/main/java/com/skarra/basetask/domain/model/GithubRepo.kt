package com.skarra.basetask.domain.model

internal data class GithubRepo(
    val id: String,
    val name: String,
    val fullName: String,
    val owner: GithubOwner,
    val description: String
)