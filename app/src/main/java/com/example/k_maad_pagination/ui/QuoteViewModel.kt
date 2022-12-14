package com.example.k_maad_pagination.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.k_maad_pagination.repo.QuotesRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(private val repo: QuotesRepo) : ViewModel() {

    val quoteList = repo.getAllQuotes().cachedIn(viewModelScope)


}