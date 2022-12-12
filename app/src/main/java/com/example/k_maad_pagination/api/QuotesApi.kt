package com.example.k_maad_pagination.api


import com.example.k_maad_pagination.model.ResponseQuotes
import retrofit2.http.GET
import retrofit2.http.Query

interface QuotesApi {

    @GET("/quotes")
    suspend fun getAllQuotes(@Query("page") page: Int): ResponseQuotes


}