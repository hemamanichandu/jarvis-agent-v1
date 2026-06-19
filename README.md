# Jarvis Agent V1

A Java-based voice-controlled desktop assistant built using Spring Boot and Vosk Speech Recognition.

The application listens to voice commands through the microphone, converts speech to text using the Vosk offline speech recognition engine, and executes desktop actions such as opening applications.

## Features

- Offline speech recognition using Vosk
- Spring Boot REST API
- Voice command processing
- Launch desktop applications through voice commands
- JSON-based command parsing
- Extendable command execution system

## Tech Stack

- Java 21
- Spring Boot 3
- Vosk Speech Recognition
- Maven
- JSON Library (org.json)

## Project Structure
src/main/java/com/chandu/jarvis
│
├── controller
│ └── VoiceController.java
│
├── voice
│ └── SpeechRecognitionService.java
│
├── command
│ └── ToolExecution.java
│
└── JarvisAgentV1Application.java


## How It Works

1. User calls the REST endpoint.
2. Microphone starts listening.
3. Vosk converts speech to text.
4. Text command is extracted from JSON.
5. Command is matched against supported actions.
6. Corresponding desktop application is launched.

Example:

Voice Input:

open chrome


Chrome Browser Opens


| Voice Command   | Action                   |
| --------------- | ------------------------ |
| open chrome     | Opens Google Chrome      |
| open notepad    | Opens Notepad            |
| open calculator | Opens Calculator         |
| open vscode     | Opens Visual Studio Code |
| spotify         | Opens Spotify            |

