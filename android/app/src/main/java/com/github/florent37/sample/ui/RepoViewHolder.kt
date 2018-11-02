package com.github.florent37.sample.ui

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.github.florent37.kotlinnative.data.Repository
import com.github.florent37.sample.R

class RepoViewHolder(view: View, clickListener: (Repository) -> Unit) : RecyclerView.ViewHolder(view) {

    val tvName: TextView
    var repository: Repository? = null

    init {
        tvName = view.findViewById(R.id.name)
        view.setOnClickListener {
            repository?.let(clickListener)
        }
    }

    fun bind(repository: Repository){
        tvName.text = repository.name
    }
}