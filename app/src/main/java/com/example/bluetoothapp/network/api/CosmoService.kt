package com.example.bluetoothapp.network.api

import com.example.bluetoothapp.data.DeviceResponse
import retrofit2.http.GET

interface CosmoService {
    @GET("test/devices")
    suspend fun getDevices(): DeviceResponse
}