package com.example.bluetoothapp.data

import com.google.gson.annotations.SerializedName

data class Device(
    @field:SerializedName("macAddress") val macAddress: String,
    @field:SerializedName("model") val model: String,
    @field:SerializedName("product") val product: String,
    @field:SerializedName("firmwareVersion") val firmwareVersion: String,
    @field:SerializedName("serial") val serial: String,
    @field:SerializedName("installationMode") val installationMode: String,
    @field:SerializedName("brakeLight") val brakeLight: Boolean,
    @field:SerializedName("lightMode") val lightMode: String,
    @field:SerializedName("lightAuto") val lightAuto: Boolean,
    @field:SerializedName("lightValue") val lightValue: Int
)
