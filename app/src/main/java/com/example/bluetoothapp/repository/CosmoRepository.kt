package com.example.bluetoothapp.repository

import com.example.bluetoothapp.data.DeviceResponse
import kotlinx.coroutines.flow.Flow

interface CosmoRepository {
    suspend fun getDevicesRepository(): DeviceResponse
}