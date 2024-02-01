package com.example.bluetoothapp.data

import com.google.gson.Gson
import org.junit.Assert.assertEquals
import org.junit.Test

class DeviceResponseTest {

    private val gson = Gson()

    @Test
    fun testSerialization() {
        val device1 = Device(
            "00:11:22:33:44:55",
            "ModelX",
            "ProductABC",
            "1.0.0",
            "123456789",
            "ModeA",
            true,
            "ModeB",
            true,
            50
        )

        val device2 = Device(
            "11:22:33:44:55:66",
            "ModelY",
            "ProductXYZ",
            "2.0.0",
            "456789012",
            "ModeC",
            true,
            "ModeD",
            false,
            75
        )

        val deviceResponse = DeviceResponse(listOf(device1, device2))

        val json = gson.toJson(deviceResponse)
        val deserializedResponse = gson.fromJson(json, DeviceResponse::class.java)

        assertEquals(deviceResponse, deserializedResponse)
    }

    @Test
    fun testEmptyDeviceList() {
        val emptyResponse = DeviceResponse(emptyList())

        assertEquals(0, emptyResponse.devices.size)
    }

    @Test
    fun testDeviceList() {
        val device1 = Device(
            "00:11:22:33:44:55",
            "ModelX",
            "ProductABC",
            "1.0.0",
            "123456789",
            "ModeA",
            true,
            "ModeB",
            true,
            50
        )

        val device2 = Device(
            "11:22:33:44:55:66",
            "ModelY",
            "ProductXYZ",
            "2.0.0",
            "456789012",
            "ModeC",
            true,
            "ModeD",
            false,
            75
        )

        val responseWithDevices = DeviceResponse(listOf(device1, device2))

        assertEquals(2, responseWithDevices.devices.size)
        assertEquals(device1, responseWithDevices.devices[0])
        assertEquals(device2, responseWithDevices.devices[1])
    }
}