package org.jetbrains.kotlinconf.data

import kotlinx.serialization.Serializable

@Serializable
data class Repository(val name: String, val id: Int)