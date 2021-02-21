package com.bado.ignacio.reddit_client.presentation

import com.bado.ignacio.reddit_client.domain.Entry
import java.util.Calendar

data class EntryView(
    val title: String,
    val author: String,
    val imageURL: String,
    val commentCount: Int,
    val hoursFromCreation: Int,
) {
    companion object {
        fun fromEntry(entry: Entry, calendar: Calendar = Calendar.getInstance()): EntryView {
            val hours = (calendar.timeInMillis / 1000 - entry.created) / 3600
            return EntryView(
                entry.title,
                entry.author,
                entry.thumbnailUrl,
                entry.commentCount,
                hours.toInt(),
            )
        }
    }
}
