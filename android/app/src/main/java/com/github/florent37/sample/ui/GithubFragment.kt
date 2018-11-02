package com.github.florent37.sample.ui

import android.os.*
import android.support.v4.app.Fragment
import android.util.Log
import android.view.*
import android.view.KeyEvent.KEYCODE_ENTER
import android.widget.Toast
import com.bumptech.glide.Glide
import com.github.florent37.kotlinnative.data.Repository
import com.github.florent37.kotlinnative.model.UserModel
import com.github.florent37.kotlinnative.presentation.GithubView
import com.github.florent37.sample.R
import com.github.florent37.sample.dependencies
import kotlinx.android.synthetic.main.fragment_user.*

class GithubFragment : Fragment(), GithubView {

    private val presenter by lazy { dependencies(context!!).githubPresenter() }

    override var isLoading: Boolean = false
        set(value) {
            loader?.visibility = if(value) View.VISIBLE else View.GONE
        }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            layoutInflater.inflate(R.layout.fragment_user, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.bind(this)

        editName.setOnKeyListener { v, keyCode, event ->
            if (keyCode == KEYCODE_ENTER) {
                val text = editName.text.toString()
                presenter.loadUser(text)
                true
            }
            false
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unbind()
    }

    override fun displayUser(user: UserModel) {
        userName.text = user.name
        company.text = user.company
        Glide.with(this).load(user.avatar_url).into(userImage)
    }

    override fun displayRepos(repos: List<Repository>) {
    }

    override fun showError(error: Throwable) {
        Log.d("error", error.localizedMessage, error)
        Toast.makeText(context, error.localizedMessage, Toast.LENGTH_SHORT).show()
    }
}