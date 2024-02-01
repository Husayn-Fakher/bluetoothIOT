package com.example.bluetoothapp.viewmodel


import com.example.bluetoothapp.MainCoroutineRule
import com.example.bluetoothapp.di.RepositoryModule
import com.example.bluetoothapp.domain.GetDevicesUseCase
import com.example.bluetoothapp.repository.FakeCosmoRepository
import com.example.bluetoothapp.runBlockingTest
import com.example.bluetoothapp.viewmodels.DevicesViewModel
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.flow.first
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
@UninstallModules(RepositoryModule::class)
class DevicesViewModelTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var fakeCosmoRepository: FakeCosmoRepository

    private val coroutineRule = MainCoroutineRule()

    private lateinit var viewModel: DevicesViewModel

    @Before
    fun setUp() {
        hiltRule.inject()

        // Use the FakeCosmoRepository in the ViewModel
        viewModel = DevicesViewModel(GetDevicesUseCase(fakeCosmoRepository))
    }


    @Test
    fun testDevicesFlow() = coroutineRule.runBlockingTest {
        // Observe the first emitted value from devicesFlow
        val firstDeviceList = viewModel.devicesFlow.first()
        val RepoDeviceList = fakeCosmoRepository.getDevicesRepository().devices

        // Assert that the first emitted value matches the expected list of devices
        assertEquals(RepoDeviceList, firstDeviceList)


    }
}

