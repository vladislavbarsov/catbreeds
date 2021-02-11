package com.example.catbreeds.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.thecatapi.com/v1/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface BreedApiService {
    @GET("breeds?limit=30&page=1/")
    suspend fun getProperties(): List<BreedProperty>
}

object BreedApi {
    val retrofitService : BreedApiService by lazy {
        retrofit.create(BreedApiService::class.java)
    }
}