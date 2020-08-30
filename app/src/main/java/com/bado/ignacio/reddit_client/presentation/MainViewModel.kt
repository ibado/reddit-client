package com.bado.ignacio.reddit_client.presentation

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.bado.ignacio.reddit_client.domain.Entry
import com.bado.ignacio.reddit_client.domain.EntryRepository
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
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