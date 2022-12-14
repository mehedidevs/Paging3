package com.example.k_maad_pagination.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.k_maad_pagination.api.QuotesApi
import com.example.k_maad_pagination.pagination.QuotesPagingSource
import javax.inject.Inject

class QuotesRepo @Inject constructor(private val quotesApi: QuotesApi) {


    fun getAllQuotes() = Pager(
        config = PagingConfig(20, maxSize = 100),
        pagingSourceFactory = { QuotesPagingSource(quotesApi) }
    ).liveData


}