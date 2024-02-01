package com.example.bluetoothapp.compose


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.bluetoothapp.data.Device
import com.example.bluetoothapp.viewmodels.DevicesViewModel
import kotlinx.coroutines.launch

@Composable
fun DevicesScreen(
    viewModel: DevicesViewModel = hiltViewModel()
) {
    val devices: List<Device> by viewModel.devicesFlow.collectAsState(emptyList())

    Scaffold(
        topBar = {
            DevicesTopBar()
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            items(devices) { device ->
                DeviceListItem(device = device)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DevicesTopBar() {
    TopAppBar(
        title = {
            Text(text = "Device List")
        }
    )
}
@Composable
private fun DeviceListItem(device: Device) {

// Create a coroutine scope
    val coroutineScope = rememberCoroutineScope()
    // Add a clickable modifier to the Text
    var showDialog by remember { mutableStateOf(false) }

    // Dialog content
    val dialogContent = buildAnnotatedString {
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
            append("Model: ")
        }
        append("${device.model}\n")

        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
            append("Product: ")
        }
        append("${device.product}\n")

        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
            append("Serial: ")
        }
        append("${device.serial}\n")

        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
            append("Firmware Version: ")
        }
        append("${device.firmwareVersion}\n")

        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
            append("Installation Mode: ")
        }
        append("${device.installationMode}\n")

        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
            append("Brake Light: ")
        }
        append("${device.brakeLight}\n")

        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
            append("Light Mode: ")
        }
        append("${device.lightMode}\n")

        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
            append("Light Auto: ")
        }
        append("${device.lightAuto}\n")

        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
            append("Light Value: ")
        }
        append("${device.lightValue}\n")
    }


    // Show the AlertDialog if showDialog is true
    if (showDialog) {
        DeviceDetailsDialog(
            title = "Device Details",
            content = dialogContent,
            onDismiss = {
                showDialog = false
            }
        )
    }
    Text(
        text = buildAnnotatedString {
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                append("Model: ")
            }
            append("${device.model}")
        },
        modifier = Modifier
            .padding(16.dp)
            .clickable {
                // Use the coroutine scope to launch a coroutine
                coroutineScope.launch {
                    // Set showDialog to true to show the AlertDialog
                    showDialog = true
                }
            }
    )
}

@Composable
private fun DeviceDetailsDialog(
    title: String,
    content: AnnotatedString,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = {
            onDismiss.invoke()
        },
        title = {
            Text(text = title)
        },
        text = {
            Text(text = content)
        },
        confirmButton = {
            Button(
                onClick = {
                    onDismiss.invoke()
                }
            ) {
                Text(text = "OK")
            }
        }
    )
}