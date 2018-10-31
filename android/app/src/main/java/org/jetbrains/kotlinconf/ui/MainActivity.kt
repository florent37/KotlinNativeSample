package org.jetbrains.kotlinconf.ui

import android.os.*
import android.support.v7.app.*
import org.jetbrains.kotlinconf.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, GithubFragment(), "GithubFragment")
                .commit()
    }
}
