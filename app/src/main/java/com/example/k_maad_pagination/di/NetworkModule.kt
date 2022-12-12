package com.example.k_maad_pagination.di

import com.example.k_maad_pagination.Constant
import com.example.k_maad_pagination.api.QuotesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun getRetrofitBuilder(): Retrofit.Builder{
        return Retrofit.Builder().baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }

    @Singleton
    @Provides
    fun  getQuoteApi( retrofit: Retrofit.Builder): QuotesApi{
        return retrofit.build().create(QuotesApi::class.java)
    }





}