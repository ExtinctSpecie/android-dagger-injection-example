package com.skarra.basetask.presentation.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.skarra.basetask.domain.model.GithubOwner
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

internal class SecondaryActivity : AppCompatActivity(), HasAndroidInjector {

    override fun androidInjector() = fragmentInjector

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var view: SecondaryView

    companion object {
        private const val GITHUB_OWNER_EXTRA = "githubOwnerExtra"
        fun getStartIntent(context: Context, githubOwner: GithubOwner): Intent {
            return Intent(context, SecondaryActivity::class.java).apply {
                this.putExtra(GITHUB_OWNER_EXTRA, githubOwner)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(view.inflate(layoutInflater, null, this))
    }

    val githubOwner: GithubOwner by lazy {
        intent.extras?.get(GITHUB_OWNER_EXTRA) as GithubOwner
    }
}