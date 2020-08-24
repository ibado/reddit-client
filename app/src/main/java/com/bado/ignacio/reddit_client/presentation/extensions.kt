package com.bado.ignacio.reddit_client.presentation

import android.app.Activity
import android.widget.ImageView
import com.bado.ignacio.reddit_client.ApplicationComponent
import com.bado.ignacio.reddit_client.di.AppComponent
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.signature.ObjectKey

val Activity.injector: AppComponent
    get() = (application as ApplicationComponent).component

fun ImageView.loadFromURL(url: String) {
    Glide.with(context)
        .load(url)
        .apply(
            RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .signature(ObjectKey(url))
        ).into(this)
}