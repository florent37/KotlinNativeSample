package org.jetbrains.kotlinconf.presentation

import org.jetbrains.kotlinconf.*
import org.jetbrains.kotlinconf.data.Repository
import org.jetbrains.kotlinconf.model.UserModel

interface GithubView : BaseView {
    var isLoading: Boolean

    fun displayUser(user: UserModel)
    fun displayRepos(repos: List<Repository>)
}
