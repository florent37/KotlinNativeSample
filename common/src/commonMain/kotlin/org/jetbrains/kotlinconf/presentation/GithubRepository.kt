package org.jetbrains.kotlinconf.presentation

import org.jetbrains.kotlinconf.data.*

interface GithubRepository {
    suspend fun getUser(name: String): UserJSON?
    suspend fun getUserRepos(userName: String): List<Repository>?
}
