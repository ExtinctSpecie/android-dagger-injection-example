package com.skarra.basetask.presentation.adapter

import com.skarra.basetask.domain.model.GithubRepo

internal sealed class GithubRepoItem {
    object Header : GithubRepoItem()
    class RepoItem(val item: GithubRepo) : GithubRepoItem()
}