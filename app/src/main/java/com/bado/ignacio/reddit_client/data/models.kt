package com.bado.ignacio.reddit_client.data

import com.squareup.moshi.Json

data class EntryData(
    val title: String,
    @field:Json(name = "author_fullname") val author: String,
    @field:Json(name = "created_utc") val created: Long,
    @field:Json(name = "thumbnail") val thumbnailUrl: String,
    @field:Json(name = "num_comments") val commentCount: Int,
)

data class TopResponse(val data: ResponseData)

data class ResponseData(val children: List<EntryObject>)

data class EntryObject(val data: EntryData)
