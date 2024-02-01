package com.example.bluetoothapp.domain

import android.util.Log
import com.example.bluetoothapp.data.DeviceResponse
import com.example.bluetoothapp.repository.CosmoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetDevicesUseCase @Inject constructor(private val cosmoRepository: CosmoRepository) {

    suspend operator fun invoke(): Flow<DeviceResponse> = flow {
        try {

            // Call the repository to get devices
            val devices = cosmoRepository.getDevicesRepository()

            // Emit the devices into the flow
            emit(devices)
        } catch (e: Exception) {
            // Handle exceptions if necessary
            // You can emit a specific error state or log the exception
            Log.e(TAG, "Error in GetDevicesUseCase: ${e.message}", e)

            throw e
        }
    }

    companion object {
        private const val TAG = "TESTDEBUG"
    }
}
