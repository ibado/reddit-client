package com.bado.ignacio.reddit_client.presentation

import android.app.Activity
import com.bado.ignacio.reddit_client.ApplicationComponent
import com.bado.ignacio.reddit_client.di.AppComponent

val Activity.injector: AppComponent
    get() = (application as ApplicationComponent).component