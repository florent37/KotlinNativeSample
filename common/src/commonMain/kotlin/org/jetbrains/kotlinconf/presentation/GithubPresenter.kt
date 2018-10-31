package org.jetbrains.kotlinconf.presentation

import kotlinx.coroutines.launch
import org.jetbrains.kotlinconf.*
import org.jetbrains.kotlinconf.data.Repository
import org.jetbrains.kotlinconf.model.UserModel
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
        launch(uiContext) {
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
            view?.isLoading = false
        }
    }

    fun loadRepos(name: String) {
        view?.isLoading = true
        launch(uiContext) {
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