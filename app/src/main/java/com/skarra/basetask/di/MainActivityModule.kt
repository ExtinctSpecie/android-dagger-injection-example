package com.skarra.basetask.di

import com.skarra.basetask.app.domain.viewmodel.factory.getViewModel
import com.skarra.basetask.app.mapper.ListMapper
import com.skarra.basetask.app.mapper.ListMapperImpl
import com.skarra.basetask.app.mapper.Mapper
import com.skarra.basetask.data.network.api.GithubReposApi
import com.skarra.basetask.data.network.apiservice.GithubReposApiService
import com.skarra.basetask.data.network.apiservice.GithubReposApiServiceImpl
import com.skarra.basetask.data.network.mapper.GithubOwnerResponseToGithubOwnerMapper
import com.skarra.basetask.data.network.mapper.GithubRepoResponseToGithubRepoMapper
import com.skarra.basetask.data.network.model.GithubOwnerResponse
import com.skarra.basetask.data.network.model.GithubRepoResponse
import com.skarra.basetask.data.repository.GithubReposRepositoryImpl
import com.skarra.basetask.domain.model.GithubOwner
import com.skarra.basetask.domain.model.GithubRepo
import com.skarra.basetask.domain.repository.GithubReposRepository
import com.skarra.basetask.domain.usecase.GetSquareReposUseCase
import com.skarra.basetask.domain.usecase.GetSquareReposUseCaseImpl
import com.skarra.basetask.presentation.router.MainActivityRouter
import com.skarra.basetask.presentation.router.MainActivityRouterImpl
import com.skarra.basetask.presentation.view.MainActivity
import com.skarra.basetask.presentation.viewmodel.MainActivityViewModel
import com.skarra.basetask.presentation.viewmodel.MainActivityViewModelImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Provider


@Module(
    includes = [
        MainActivityModule.ProvidesModule::class,
        MainActivityModule.BindsModule::class
    ]
)
internal interface MainActivityModule {

    @Module
    interface BindsModule {
        @Binds
        fun bindsMainActivityRouter(router: MainActivityRouterImpl): MainActivityRouter

        @Binds
        fun bindsGetSquareReposUseCase(useCase: GetSquareReposUseCaseImpl): GetSquareReposUseCase

        @Binds
        fun bindsGithubReposRepository(repository: GithubReposRepositoryImpl): GithubReposRepository

        @Binds
        fun bindsGithubReposApiService(service: GithubReposApiServiceImpl): GithubReposApiService

        @Binds
        fun bindsGithubRepoResponseMapper(mapper: GithubRepoResponseToGithubRepoMapper): Mapper<GithubRepoResponse, GithubRepo>

        @Binds
        fun bindsGithubOwnerResponseMapper(mapper: GithubOwnerResponseToGithubOwnerMapper): Mapper<GithubOwnerResponse, GithubOwner>
    }

    @Module
    object ProvidesModule {

        @JvmStatic
        @Provides
        fun providesGithubRepoResponseListMapper(repoMapper: Mapper<GithubRepoResponse, GithubRepo>): ListMapper<GithubRepoResponse, GithubRepo> {
            return ListMapperImpl(repoMapper)
        }

        @JvmStatic
        @Provides
        fun providesGetR(@Named("github_orgs_api") retrofit: Retrofit): GithubReposApi {
            return retrofit.create(GithubReposApi::class.java)
        }

        @JvmStatic
        @Provides
        fun providesMainActivityViewModel(
            viewModelProvider: Provider<MainActivityViewModelImpl>,
            activity: MainActivity
        ): MainActivityViewModel {
            return activity.getViewModel { viewModelProvider.get() }
        }
    }
}