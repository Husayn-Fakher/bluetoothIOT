# Bluetooth IOT App

This Android application, developed in Kotlin, utilizes Jetpack Compose for building the UI. The app incorporates features such as retrieving data from the Cosmo API, detailed device information screens, Bluetooth device discovery, and more.

## Features

1. **API Connection:**
   - Retrieve data from the Cosmo API's devices endpoint.

2. **Detailed Device Information:**
   - Each list item opens a new screen with detailed information about the selected device.

3. **Bluetooth Device Discovery:**
   - Detect nearby Bluetooth devices.
   - Connect to Bluetooth devices and display discovered characteristics.

4. **User Interface Design:**
   - Designed with creativity to provide an engaging and user-friendly experience.

## Architecture

The app follows the MVVM architecture with clean architecture principles, including use of useCases and repositories.

- **MVVM Architecture:** The app is structured using the Model-View-ViewModel (MVVM) architectural pattern for a clear separation of concerns.

- **Clean Architecture Features:**
  - **UseCases:** Centralized business logic in use cases.
  - **Repositories:** Data source abstraction for fetching data.

## Tech Stack

- **Jetpack Compose:** Modern Android UI toolkit for building native UIs.
- **Hilt:** Dependency injection framework for Android.
- **Coroutines:** For handling asynchronous tasks and flows.
- **Espresso and JUnit:** Used for unit and instrumented testing.

## Bluetooth Communication

- **GATT (Generic Attribute Profile):**
  - The app utilizes GATT for communication between Bluetooth or IOT devices.
  - GATT defines a hierarchical data structure and set of procedures, providing a framework for discovering services and characteristics on Bluetooth Low Energy (BLE) devices.

## Dependencies

- **Compose Libraries:**
  - `androidx.compose.ui`
  - `androidx.compose.ui:ui-tooling`
  - `androidx.compose.material3`

- **Dependency Injection:**
  - Hilt for Android.

- **Networking:**
  - Retrofit for API communication.
  - Gson for JSON serialization.

- **Bluetooth Communication:**
  - GATT for Bluetooth communication.

## Build and Run

Follow these steps to build and run the application:

1. Clone the repository.
2. Open the project in Android Studio.
3. Build and run

## Testing

- **Unit Tests:** Utilize JUnit for unit tests.
- **Instrumented Tests:** Challenges faced and solved with Bluetooth permissions. Tested on Android 11.0 device.
