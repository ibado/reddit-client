package com.bado.ignacio.reddit_client.presentation

sealed class Result<out T> {
    data class Ok<out T>(val value: T) : Result<T>()
    data class Error(val throwable: Throwable) : Result<Nothing>()
}
