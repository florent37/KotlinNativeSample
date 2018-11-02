package com.github.florent37.kotlinnative.data

import io.ktor.client.call.*
import kotlinx.serialization.*
import kotlinx.serialization.json.*
import com.github.florent37.kotlinnative.*
import com.github.florent37.kotlinnative.api.*
import com.github.florent37.kotlinnative.data.*
import com.github.florent37.kotlinnative.log.PlatformLogger
import com.github.florent37.kotlinnative.presentation.*
import com.github.florent37.kotlinnative.storage.*
import kotlin.properties.*
import kotlin.properties.Delegates.observable

class GithubRepositoryImpl(logger: PlatformLogger) : GithubRepository {

    private val api = GithubApi(logger)

    override suspend fun getUser(name: String): UserJSON? =
            api.getUser(name)

    //not working on iOS
    override suspend fun getUserRepos(userName: String): List<Repository>? =
            api.getUserRepos(userName)

    init {
    }
}