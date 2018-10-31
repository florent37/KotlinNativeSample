package org.jetbrains.kotlinconf.ui

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import org.jetbrains.kotlinconf.R
import org.jetbrains.kotlinconf.data.Repository

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