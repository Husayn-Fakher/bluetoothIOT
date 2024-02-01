package com.example.bluetoothapp.repository

import com.example.bluetoothapp.data.Device
import com.example.bluetoothapp.data.DeviceResponse
import javax.inject.Inject


class FakeCosmoRepository @Inject constructor() : CosmoRepository {

    // Dummy data for testing
    private val fakeDevices = listOf(
        Device(
            "00:11:22:33:44:55",
            "Test Model",
            "Test Product",
            "1.0",
            "123456",
            "Test Mode",
            true,
            "Auto",
            true,
            50
        )
    )

    override suspend fun getDevicesRepository(): DeviceResponse {

        return DeviceResponse(fakeDevices)
    }
}