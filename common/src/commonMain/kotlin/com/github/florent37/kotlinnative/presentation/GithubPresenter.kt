package com.github.florent37.kotlinnative.presentation

import kotlinx.coroutines.launch
import com.github.florent37.kotlinnative.*
import com.github.florent37.kotlinnative.data.Repository
import com.github.florent37.kotlinnative.model.UserModel
import kotlinx.coroutines.GlobalScope
import kotlin.coroutines.*

class GithubPresenter(
    private val uiContext: CoroutineContext,
    private val repository: GithubRepository
) {

    private var view: GithubView? = null

    fun bind(view: GithubView){
        this.view = view
    }

    fun unbind() {
        view = null
    }

    fun loadUser(name: String) {
        view?.isLoading = true
        GlobalScope.launch(uiContext) {
            try {
                repository.getUser(name)?.let { user ->
                    val userModel = UserModel(
                            user.name,
                            user.avatar_url,
                            user.company
                    )
                    view?.displayUser(userModel)
                }
            }catch (e: Exception){
                view?.showError(e)
            }
            try {
                repository.getUserRepos(name)?.let { repositories ->
                    view?.displayRepos(repositories)
                }
            }catch (e: Exception){
                view?.showError(e)
            }
            view?.isLoading = false
        }
    }

    fun onRepoClicked(repo: Repository){

    }
}