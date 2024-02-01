package com.example.bluetoothapp.data

import com.google.gson.Gson
import org.junit.Assert.assertEquals
import org.junit.Test

class DeviceTest {

    private val gson = Gson()

    @Test
    fun testSerialization() {
        val device = Device(
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

        val json = gson.toJson(device)
        val deserializedDevice = gson.fromJson(json, Device::class.java)

        assertEquals(device, deserializedDevice)
    }

    @Test
    fun testToString() {
        val device = Device(
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

        val expectedToString =
            "Device(macAddress=11:22:33:44:55:66, model=ModelY, product=ProductXYZ, firmwareVersion=2.0.0, " + "serial=456789012, installationMode=ModeC, brakeLight=true, lightMode=ModeD, lightAuto=false, lightValue=75)"

        assertEquals(expectedToString, device.toString())
    }

    @Test
    fun testEquality() {
        val device1 = Device(
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

        assertEquals(device1, device2)
    }

    @Test
    fun testInequality() {
        val device1 = Device(
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

        val device2 = Device(
            "00:00:00:00:00:00",
            "DefaultModel",
            "DefaultProduct",
            "1.0.0",
            "987654321",
            "DefaultMode",
            false,
            "DefaultLightMode",
            false,
            0
        )

        assert(device1 != device2)
    }
}