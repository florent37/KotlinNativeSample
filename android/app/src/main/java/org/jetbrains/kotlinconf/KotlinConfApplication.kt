package org.jetbrains.kotlinconf

import android.app.*
import android.content.*
import android.support.multidex.*

class KotlinConfApplication : Application() {

    val dependencyManager: DependencyManager by lazy { DependencyManager(this) }

    override fun onCreate() {
        super.onCreate()

        Thread.setDefaultUncaughtExceptionHandler { _, throwable ->
            println(throwable)
            throwable.printStackTrace()
            throwable?.cause?.printStackTrace()
        }
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

}