package org.jetbrains.kotlinconf.data

import kotlinx.serialization.Serializable

@Serializable
data class UserJSON (
        val login: String,
        val id: Int,
        val name: String,
        val avatar_url: String,
        val company: String
)
