package com.example.bluetoothapp


import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTouchInput
import androidx.test.espresso.action.ViewActions.swipeLeft
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.GrantPermissionRule
import com.example.bluetoothapp.di.RepositoryModule
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@HiltAndroidTest
@UninstallModules(RepositoryModule::class)
class HomeScreenInstrumentedTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @get:Rule
    var mRuntimePermissionRule = GrantPermissionRule.grant(
        android.Manifest.permission.BLUETOOTH,
        android.Manifest.permission.BLUETOOTH_ADMIN,
        android.Manifest.permission.ACCESS_FINE_LOCATION,
        android.Manifest.permission.ACCESS_COARSE_LOCATION
    )

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testNavigationToDevicesTab() {
        // Click on the Bluetooth tab
        composeTestRule.onNodeWithText("Devices").performClick()
        composeTestRule.onNodeWithText("Device List").assertIsDisplayed()
    }

    @Test
    fun testNavigationToBluetoothTab() {
        // Click on the Bluetooth tab
        composeTestRule.onNodeWithText("Nearby Bluetooth Devices").performClick()
        // Assert that the PagerState is updated
        composeTestRule.onNodeWithText("Available devices").assertIsDisplayed()
    }

    @Test
    fun testHorizontalPagerExists() {
        // Assert that the HorizontalPager exists using the test tag
        composeTestRule.onNodeWithTag("horizontalPagerTag").assertExists()
    }

    @Test
    fun testHorizontalPagerSwipe() {
        composeTestRule.onRoot().performTouchInput {
            swipeLeft()
        }
        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithText("Device List").assertIsDisplayed()

    }
}