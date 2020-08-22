package com.bado.ignacio.reddit_client

import android.app.Application
import com.bado.ignacio.reddit_client.di.AppComponent
import com.bado.ignacio.reddit_client.di.DaggerAppComponent

class App : Application(), ApplicationComponent {

    override val component = DaggerAppComponent.factory().create(this)
}

interface ApplicationComponent {
    val component: AppComponent
}