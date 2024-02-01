package com.example.bluetoothapp.network.retrofit

import com.example.bluetoothapp.data.DeviceResponse
import com.example.bluetoothapp.network.CosmoDataSource
import com.example.bluetoothapp.network.api.CosmoService
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import javax.inject.Inject
import javax.inject.Singleton



@Singleton
class RetrofitCosmo @Inject constructor(
    cosmoService: CosmoService
) : CosmoDataSource {

    private val networkApi = cosmoService

    override suspend fun getDevicesSource(): DeviceResponse = networkApi.getDevices()
}