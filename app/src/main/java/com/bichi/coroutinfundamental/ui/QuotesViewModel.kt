package com.bichi.coroutinfundamental.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bichi.coroutinfundamental.data.models.Movie
import com.bichi.coroutinfundamental.data.models.Quote
import com.bichi.coroutinfundamental.data.network.MyApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class QuotesViewModel :ViewModel(){
    val quotes : LiveData<List<Quote>>? = MutableLiveData()

    init {
        viewModelScope.launch {
           quotes as MutableLiveData
           quotes.value = getQuotes()
        }
    }

    private suspend fun getQuotes(): List<Quote>? {
        return withContext(Dispatchers.IO){ MyApi().getQuotes().body()?.quotes} //Dispatchers.IO for network request
    }

    private suspend fun getMovies(): List<Movie>? {
        return withContext(Dispatchers.IO){ MyApi().getMovies().body()} //Dispatchers.IO for network request
    }
}