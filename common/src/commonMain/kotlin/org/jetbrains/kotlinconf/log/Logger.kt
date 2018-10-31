package org.jetbrains.kotlinconf.log

interface PlatformLogger {

    fun logException(tag: String, text: String, exception: Throwable?) {

    }

    fun log(tag: String, text: String) {

    }
}