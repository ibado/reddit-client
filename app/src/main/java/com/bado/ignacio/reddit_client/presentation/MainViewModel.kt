package com.bado.ignacio.reddit_client.presentation

import androidx.lifecycle.*
import com.bado.ignacio.reddit_client.domain.Entry
import com.bado.ignacio.reddit_client.domain.EntryRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: EntryRepository) : ViewModel() {

    private val _entries = MutableLiveData<Result<List<Entry>>>()

    val entries: LiveData<Result<List<Entry>>> = _entries

    init {
        viewModelScope.launch {
            try {
                val topEntries = repository.getTop()
                _entries.value = Result.Ok(topEntries)
            } catch (throwable: Throwable) {
                _entries.value = Result.Error(throwable)
            }
        }
    }

    class Factory  @Inject constructor(
        private val repository: EntryRepository
    ) : ViewModelProvider.Factory {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>) = MainViewModel(repository) as T
    }
}