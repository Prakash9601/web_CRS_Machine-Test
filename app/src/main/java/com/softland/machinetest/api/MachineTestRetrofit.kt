package com.softland.machinetest.api



import com.softland.machinetest.model.Items
import com.softland.machinetest.model.itemsId
import com.softland.machinetest.utils.Const.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


interface MachineTestRetrofit {
    @GET("products")
    suspend fun getProduct(): Response<Items?>?

    @GET("products/{productId}")
    suspend fun getProductId(@Path("productId") productId: Int): Response<itemsId?>?


    companion object {
        fun create(): MachineTestRetrofit {
            val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }
            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MachineTestRetrofit::class.java)
        }
    }
}