package org.jetbrains.kotlinconf.ui

import android.os.*
import android.support.v4.app.Fragment
import android.util.Log
import android.view.*
import android.view.KeyEvent.KEYCODE_ENTER
import android.widget.Toast
import com.bumptech.glide.Glide
import org.jetbrains.kotlinconf.*
import org.jetbrains.kotlinconf.R
import org.jetbrains.kotlinconf.data.Repository
import org.jetbrains.kotlinconf.presentation.*
import kotlinx.android.synthetic.main.fragment_user.*
import org.jetbrains.kotlinconf.model.UserModel

class GithubFragment : Fragment(), GithubView {

    override var isLoading: Boolean = false
        set(value) {
            loader?.visibility = if(value) View.VISIBLE else View.GONE
        }

    private val presenter by lazy { dependencies(context!!).githubPresenter() }

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

    override fun displayRepos(repos: List<Repository>) {
    }

    override fun displayUser(user: UserModel) {
        userName.text = user.name
        company.text = user.company
        Glide.with(this).load(user.avatar_url).into(userImage)
        Log.d("test", user.toString())
    }

    override fun showError(error: Throwable) {
        Log.d("error", error.localizedMessage, error)
        Toast.makeText(context, error.localizedMessage, Toast.LENGTH_SHORT).show()
    }
}