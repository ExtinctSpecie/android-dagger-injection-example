package com.skarra.basetask.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.skarra.basetask.R
import com.skarra.basetask.databinding.GithubRepoItemViewBinding
import com.skarra.basetask.domain.model.GithubRepo

internal class GithubReposAdapter(
    private val lifecycleOwner: LifecycleOwner
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items = arrayListOf<GithubRepoItem>()
    private var index = 0

    private companion object {
        const val ITEM_TYPE = 0
        const val HEADER_TYPE = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when (viewType) {
            ITEM_TYPE -> {
                val binding =
                    GithubRepoItemViewBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                binding.lifecycleOwner = lifecycleOwner
                GithubRepoItemViewHolder(binding)
            }
            else -> {
                HeaderViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.github_repo_header_view,
                        parent,
                        false
                    )
                )
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is GithubRepoItemViewHolder) {
            items[position].apply {
                if (this is GithubRepoItem.RepoItem) {
                    holder.bind(this.item){
                        index++
                        println("callBackCalled for $index")
                    }
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (items[position] is GithubRepoItem.RepoItem) ITEM_TYPE else HEADER_TYPE
    }

    fun setItems(recipes: List<GithubRepoItem>) {
        items.clear()
        items.add(GithubRepoItem.Header)
        items.addAll(recipes)
        println("${items.size}")
        notifyDataSetChanged()
    }

    class GithubRepoItemViewHolder(
        private val binding: GithubRepoItemViewBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(githubRepo: GithubRepo, callBack: () -> Unit) {
            binding.model = githubRepo
            binding.someCheckbox.setOnCheckedChangeListener { compoundButton, b ->
                callBack.invoke()
            }
        }
    }

    class HeaderViewHolder(view: View) : RecyclerView.ViewHolder(view)
}