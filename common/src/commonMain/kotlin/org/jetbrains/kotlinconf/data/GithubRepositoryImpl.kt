package org.jetbrains.kotlinconf.model

import io.ktor.client.call.*
import kotlinx.serialization.*
import kotlinx.serialization.json.*
import org.jetbrains.kotlinconf.*
import org.jetbrains.kotlinconf.api.*
import org.jetbrains.kotlinconf.data.*
import org.jetbrains.kotlinconf.log.PlatformLogger
import org.jetbrains.kotlinconf.presentation.*
import org.jetbrains.kotlinconf.storage.*
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