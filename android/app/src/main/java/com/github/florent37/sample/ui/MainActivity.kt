package com.github.florent37.sample.ui

import android.os.*
import android.support.v7.app.*
import com.github.florent37.sample.R

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
