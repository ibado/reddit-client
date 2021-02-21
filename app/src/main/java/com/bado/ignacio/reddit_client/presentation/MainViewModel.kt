package com.bado.ignacio.reddit_client.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bado.ignacio.reddit_client.domain.Entry
import com.bado.ignacio.reddit_client.domain.EntryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: EntryRepository
) : ViewModel() {

    private val _entries = MutableLiveData<Result<List<Entry>>>()

    val entries: LiveData<Result<List<Entry>>> = _entries

    init {
        fetchEntries()
    }

    fun refresh() = fetchEntries()

    private fun fetchEntries() {
        viewModelScope.launch {
            try {
                val topEntries = repository.getTop()
                _entries.value = Result.Ok(topEntries)
            } catch (throwable: Throwable) {
                _entries.value = Result.Error(throwable)
            }
        }
    }
}
