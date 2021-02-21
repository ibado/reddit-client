package com.bado.ignacio.reddit_client.presentation

import com.bado.ignacio.reddit_client.domain.Entry
import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.Calendar

class EntryViewTest {

    @Test
    fun `created from domain entry has correct hours from creation`() {
        val entry = Entry(
            "title",
            "author",
            1598599673L,
            "url",
            23,
        )

        val calendar = Calendar.getInstance()
        calendar.timeInMillis = 1598649261506
        val actual = EntryView.fromEntry(entry, calendar)

        assertEquals(13, actual.hoursFromCreation)
    }
}
