package com.skarra.basetask.presentation.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.skarra.basetask.app.presentation.SkipHeaderLineDividerItemDecoration
import com.skarra.basetask.databinding.ActivityMainBinding
import com.skarra.basetask.domain.model.GithubRepo
import com.skarra.basetask.presentation.adapter.GithubRepoItem
import com.skarra.basetask.presentation.adapter.GithubReposAdapter
import com.skarra.basetask.presentation.router.MainActivityRouter
import com.skarra.basetask.presentation.viewmodel.MainActivityViewModel
import javax.inject.Inject

internal class MainView @Inject constructor(
    private val router: MainActivityRouter,
    private val viewModel: MainActivityViewModel
) {

    fun inflate(
        inflater: LayoutInflater,
        container: ViewGroup?,
        lifecycleOwner: LifecycleOwner
    ): View {
        val binding = ActivityMainBinding.inflate(inflater, container, false).apply {
            this.lifecycleOwner = lifecycleOwner
            this.model = viewModel
        }


        observeViewModel(binding)
        setupClickListeners(binding)
        setupRecyclerView(binding)
        viewModel.fetchSquareRepos()
        return binding.root
    }

    private fun observeViewModel(binding: ActivityMainBinding) {
        binding.lifecycleOwner?.let {
            viewModel.githubRepos.observe(it, Observer {
                addGithubReposToRecyclerView(binding, it)
            })

        }
    }

    private fun setupClickListeners(binding: ActivityMainBinding){
        binding.goToSecondaryViewBtn.setOnClickListener {
            router.goToSecondaryActivity()
        }
    }

    private fun addGithubReposToRecyclerView(
        binding: ActivityMainBinding,
        repos: List<GithubRepo>
    ) {
        (binding.githubReposRv.adapter as? GithubReposAdapter?)?.setItems(
            repos.map { GithubRepoItem.RepoItem(it) }
        )
    }

    private fun setupRecyclerView(binding: ActivityMainBinding) {
        binding.lifecycleOwner?.let {

            binding.githubReposRv.apply {
                layoutManager = LinearLayoutManager(context).apply {
                    orientation = LinearLayoutManager.VERTICAL
                    adapter = GithubReposAdapter(
                        it
                    )
                    isAutoMeasureEnabled = false
                }
                addItemDecoration(SkipHeaderLineDividerItemDecoration(context))
            }
        }
    }
}