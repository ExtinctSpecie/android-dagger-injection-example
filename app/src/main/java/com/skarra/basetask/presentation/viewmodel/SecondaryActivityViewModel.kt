package com.skarra.basetask.presentation.viewmodel

import androidx.lifecycle.LiveData
import com.skarra.basetask.domain.model.GithubRepo

internal interface SecondaryActivityViewModel {
    val userName: LiveData<String>
}