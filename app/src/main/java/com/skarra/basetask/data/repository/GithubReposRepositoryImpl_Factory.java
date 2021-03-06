// Generated by Dagger (https://dagger.dev).
package com.skarra.basetask.data.repository;

import com.skarra.basetask.app.mapper.ListMapper;
import com.skarra.basetask.data.network.apiservice.GithubReposApiService;
import com.skarra.basetask.data.network.model.GithubRepoResponse;
import com.skarra.basetask.domain.model.GithubRepo;
import dagger.internal.Factory;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class GithubReposRepositoryImpl_Factory implements Factory<GithubReposRepositoryImpl> {
  private final Provider<ListMapper<GithubRepoResponse, GithubRepo>> githubReposMapperProvider;

  private final Provider<GithubReposApiService> githubReposApiServiceProvider;

  public GithubReposRepositoryImpl_Factory(
      Provider<ListMapper<GithubRepoResponse, GithubRepo>> githubReposMapperProvider,
      Provider<GithubReposApiService> githubReposApiServiceProvider) {
    this.githubReposMapperProvider = githubReposMapperProvider;
    this.githubReposApiServiceProvider = githubReposApiServiceProvider;
  }

  @Override
  public GithubReposRepositoryImpl get() {
    return newInstance(githubReposMapperProvider.get(), githubReposApiServiceProvider.get());
  }

  public static GithubReposRepositoryImpl_Factory create(
      Provider<ListMapper<GithubRepoResponse, GithubRepo>> githubReposMapperProvider,
      Provider<GithubReposApiService> githubReposApiServiceProvider) {
    return new GithubReposRepositoryImpl_Factory(githubReposMapperProvider, githubReposApiServiceProvider);
  }

  public static GithubReposRepositoryImpl newInstance(
      ListMapper<GithubRepoResponse, GithubRepo> githubReposMapper,
      GithubReposApiService githubReposApiService) {
    return new GithubReposRepositoryImpl(githubReposMapper, githubReposApiService);
  }
}
