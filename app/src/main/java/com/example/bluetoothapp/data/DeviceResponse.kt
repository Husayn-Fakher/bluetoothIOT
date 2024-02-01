package com.example.bluetoothapp.data

import com.google.gson.annotations.SerializedName

data class DeviceResponse(
    @field:SerializedName("devices") val devices: List<Device>
)