package com.bado.ignacio.reddit_client.data

import com.squareup.moshi.Json

data class EntryData(
    val title: String,
    @field:Json(name = "author_fullname") val author: String,
    val created: Long,
    @field:Json(name = "thumbnail") val thumbnailUrl: String,
    @field:Json(name = "num_comments") val commentCount: Int,
)

data class TopResponse(val data: Data)

data class Data(val children: List<EntryObject>)

data class EntryObject(val data: EntryData)
