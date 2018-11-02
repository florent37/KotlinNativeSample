package com.github.florent37.kotlinnative.presentation

import com.github.florent37.kotlinnative.*
import com.github.florent37.kotlinnative.data.Repository
import com.github.florent37.kotlinnative.model.UserModel

interface GithubView : BaseView {
    var isLoading: Boolean

    fun displayUser(user: UserModel)
    fun displayRepos(repos: List<Repository>)
}
