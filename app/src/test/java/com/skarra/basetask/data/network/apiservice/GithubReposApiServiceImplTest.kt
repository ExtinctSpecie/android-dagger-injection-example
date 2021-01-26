package com.skarra.basetask.data.network.apiservice

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.skarra.basetask.RxSynchronizeSchedulersRule
import com.skarra.basetask.data.network.api.GithubReposApi
import com.skarra.basetask.data.network.model.GithubRepoResponse
import io.reactivex.Single
import org.junit.Rule
import org.junit.Test


internal class GithubReposApiServiceImplTest {

    @get:Rule
    val rxSynchronizeSchedulersRule = RxSynchronizeSchedulersRule()

    private val api: GithubReposApi = mock()
    private val sut = GithubReposApiServiceImpl(api)

    @Test
    fun `getSquareGithubRepos SHOULD return a list of square repos`() {
        val expected: List<GithubRepoResponse> = mock()
        whenever(api.getSquareRepos()).thenReturn(Single.just(expected))

        val result = sut.getSquareGithubRepos().test()

        result.assertValue(expected)
    }
}