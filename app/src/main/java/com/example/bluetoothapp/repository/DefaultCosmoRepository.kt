package com.example.bluetoothapp.repository

import com.example.bluetoothapp.data.DeviceResponse
import com.example.bluetoothapp.network.retrofit.RetrofitCosmo
import javax.inject.Inject

internal class DefaultCosmoRepository @Inject constructor(private val network :RetrofitCosmo): CosmoRepository{
    override  suspend fun getDevicesRepository(): DeviceResponse = network.getDevicesSource()
}