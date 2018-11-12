package com.github.florent37.sample

import android.app.Application
import android.content.Context
import android.util.Log
import kotlinx.coroutines.Dispatchers
import com.github.florent37.kotlinnative.log.PlatformLogger
import com.github.florent37.kotlinnative.data.GithubRepositoryImpl
import com.github.florent37.kotlinnative.presentation.GithubPresenter
import com.github.florent37.kotlinnative.presentation.GithubRepository

class DependencyManager(private val application: Application) {

    val githubRepository: GithubRepository by lazy {
        GithubRepositoryImpl(logger)
    }

    val coroutineContext by lazy { Dispatchers.Main }

    val logger: PlatformLogger by lazy {
        object : PlatformLogger {
            override fun logException(tag: String, text: String, exception: Throwable?) {
                Log.e(tag, text, exception)
            }

            override fun log(tag: String, text: String) {
                Log.d(tag, text)
            }
        }
    }

    fun githubPresenter() = GithubPresenter(coroutineContext, githubRepository)
}

fun dependencies(context: Context): DependencyManager {
    val app = context.applicationContext
    val kotlinConfApplication = app as MainApplication
    return kotlinConfApplication.dependencyManager
}