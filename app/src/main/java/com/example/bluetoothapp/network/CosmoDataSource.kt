package com.example.bluetoothapp.network

import com.example.bluetoothapp.data.DeviceResponse

interface CosmoDataSource {
    suspend fun getDevicesSource(): DeviceResponse
}