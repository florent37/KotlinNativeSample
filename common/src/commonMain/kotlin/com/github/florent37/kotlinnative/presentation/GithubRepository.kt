package com.github.florent37.kotlinnative.presentation

import com.github.florent37.kotlinnative.data.*

interface GithubRepository {
    suspend fun getUser(name: String): UserJSON?
    suspend fun getUserRepos(userName: String): List<Repository>?
}
