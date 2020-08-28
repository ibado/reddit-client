package com.bado.ignacio.reddit_client.data

import com.bado.ignacio.reddit_client.domain.Entry
import com.squareup.moshi.Json

data class TopResponse(val data: ResponseData) {
    fun toEntryList(): List<Entry> {
        return this.data.children.map {
            val data = it.data
            Entry(
                data.title,
                data.author,
                data.created,
                data.thumbnailUrl,
                data.commentCount,
            )
        }.toList()
    }
}

data class ResponseData(val children: List<EntryObject>)

data class EntryObject(val data: EntryData)

data class EntryData(
    val title: String,
    @field:Json(name = "author_fullname") val author: String,
    @field:Json(name = "created_utc") val created: Long,
    @field:Json(name = "thumbnail") val thumbnailUrl: String,
    @field:Json(name = "num_comments") val commentCount: Int,
)
