package com.example.bluetoothapp.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bluetoothapp.data.Device
import com.example.bluetoothapp.data.DeviceResponse
import com.example.bluetoothapp.domain.GetDevicesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DevicesViewModel @Inject constructor(private val getDevicesUseCase: GetDevicesUseCase) :
    ViewModel() {

    private val _devicesFlow = MutableStateFlow<List<Device>>(emptyList())
    val devicesFlow: Flow<List<Device>> = _devicesFlow

    init {
        // Start the use case when the ViewModel is created
        viewModelScope.launch {

            getDevicesUseCase().collect { deviceResponse ->
                    // Update the StateFlow with the list of devices
                    _devicesFlow.value = deviceResponse.devices
                }
        }
    }


}