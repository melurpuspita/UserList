# User List Application

## Overview

The **User List Application** is a simple Android app designed to display a list of users fetched from a GitHub API. It allows users to view a collection of profiles, showcasing basic information like usernames, avatars, and links to the users' GitHub profiles.

This app demonstrates how to integrate an external API, parse JSON data, and present it in a user-friendly interface using **RecyclerView** in Android.

## Features

- **User List Display**: The app fetches a list of users from a public API and displays them in a scrollable list.
- **Profile Details**: Each user entry shows the username, avatar, and a clickable link to the user’s GitHub profile.
- **Networking with Retrofit**: The app uses **Retrofit** for making HTTP requests to the GitHub API.
- **Efficient Image Loading**: User avatars are loaded efficiently using **Glide** to handle image caching and loading

## API Used

The application fetches data from the following GitHub API:

- **GitHub Users API**: This API provides information about GitHub users.
  - Example Endpoint: `https://api.github.com/users`

This API returns a list of users, each containing data such as:
- `id`: The user's unique GitHub ID.
- `login`: The user's GitHub username.
- `avatar_url`: URL to the user's profile picture.
- `blog`: URL of the user's personal website or blog.
- `company`: The user's company or organization that the user is affiliated with.
- `followers`: The number of other GitHub users who follow this user's public activity.
- `following`: The number of users that this specific GitHub user is following.
- `location`: The geographical location provided by the user.
- `name`: The full name of the user as displayed on their GitHub profile.
- `public_gists`: The number of public gists that the user has shared..
- `public_repos`: The number of public repositories the user has created on GitHub.

## Technology Stack

- **Android Studio**: Development environment.
- **Kotlin**: Programming language for the app.
- **Retrofit**: For making network requests and handling API responses.
- **Coroutines**: For managing background tasks efficiently.
- **Gson**: For parsing JSON responses.
- **Glide**: For loading and caching images.
- **RecyclerView**: For displaying the user list.
- **Jetpack Libraries**: Libraries that provide architecture components such as `ViewModel`, `LiveData`, and `Room` database.
- **Dagger Hilt**: For simplifying the implementation in Android applications and provides built-in support for standard Android classes like `Application`, `Activity`, `Fragment`, `Service`, and `ViewModel`.
- **MVVM Architecture**: Following the MVVM design pattern to separate concerns.

## How It Works

1. **API Request**: On app launch, a network request is made to the GitHub Users API.
2. **Data Parsing**: The JSON response is parsed into user objects using Retrofit and Gson.
3. **Data Display**: The parsed data is displayed in a RecyclerView, where each item shows the user's username, avatar, bio, and other available details.
4. **Profile Search**: Search for users by entering a keyword or partial match of their username, allowing the application to filter and display a list of users whose usernames contain the entered keyword.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- **Operating System:** Windows, macOS, or Linux
- **Android Studio:** Version 4.0 or higher
- **JDK:** Java Development Kit (JDK 8 or higher)
- **Android SDK:** Ensure the required SDKs and tools are installed.

### Tools Required:

1. **Android Studio:** Download and install [Android Studio](https://developer.android.com/studio).
2. **JDK:** Ensure you have the correct version of Java Development Kit installed. You can download it from [here](https://www.oracle.com/java/technologies/javase-downloads.html).

## Cloning the Repository

To get a local copy up and running, follow these simple steps:

1. **Clone the repository:**
   ```bash
   git clone https://github.com/melurpuspita/UserList.git

2. Open Android Studio:
    Choose "Open an existing Android Studio project". Navigate to the folder where you cloned the repository and select it.


## Building the Project

1.  **Open the Project in Android Studio**:
    
    *   If you haven't already, open the project by selecting the folder where you cloned the project.
    
2.  **Sync Gradle**:
    
    *   Android Studio will automatically detect that the project needs to sync Gradle.
    *   If not, click `File > Sync Project with Gradle Files`.
    
3.  **Select a Build Variant (Optional)**:
    
    *   Go to `Build > Select Build Variant`, and select the appropriate variant, e.g., `debug` or `release`.
    
4.  **Build the Project**:
    
    *   Click `Build > Build Bundle(s) / APK(s) > Build APK(s)` to generate the APK for your project.

## Running the Project

1.  **Set Up an Emulator (Optional)**:
    
    *   In Android Studio, go to `Tools > AVD Manager`, create a new virtual device (emulator), and select a system image (e.g., API level 30).
    *   Start the emulator by clicking the play button in the AVD Manager.
    
2.  **Connect a Physical Device (Optional)**:
    
    *   Enable Developer Options on your Android device.
    *   Connect the device via USB and ensure USB Debugging is enabled.
    *   Android Studio should automatically detect your device.
    
3.  **Run the App**:
    
    *   Click the green `Run` button in the toolbar, or go to `Run > Run 'app'`.
    *   Choose your target device (either a connected device or an emulator).

## Troubleshooting

*   **Gradle Sync Issues**: If there are errors during Gradle sync, try re-syncing the project by clicking `File > Sync Project with Gradle Files`.
*   **Emulator Issues**: Ensure your emulator has the correct system image and is properly configured in the AVD Manager.
*   **Build Errors**: Verify that you are using the correct version of the Android SDK and dependencies in `build.gradle`.

   
