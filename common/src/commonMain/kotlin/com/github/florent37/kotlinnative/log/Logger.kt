package com.github.florent37.kotlinnative.log

interface PlatformLogger {

    fun logException(tag: String, text: String, exception: Throwable?) {

    }

    fun log(tag: String, text: String) {

    }
}