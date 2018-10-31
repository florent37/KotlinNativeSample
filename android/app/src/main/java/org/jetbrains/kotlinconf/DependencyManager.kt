package org.jetbrains.kotlinconf

import android.app.Application
import android.content.Context
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.android.Main
import org.jetbrains.kotlinconf.log.PlatformLogger
import org.jetbrains.kotlinconf.model.GithubRepositoryImpl
import org.jetbrains.kotlinconf.presentation.GithubPresenter
import org.jetbrains.kotlinconf.presentation.GithubRepository

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
    val kotlinConfApplication = app as KotlinConfApplication
    return kotlinConfApplication.dependencyManager
}