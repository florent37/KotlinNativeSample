package com.github.florent37.kotlinnative.data

import kotlinx.serialization.Serializable

@Serializable
data class Repository(val name: String, val id: Int)