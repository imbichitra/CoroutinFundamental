package com.bichi.coroutinfundamental.data.models

data class QuotesResponse (
    val isSuccessful: Boolean,
    val quotes: List<Quote>
)