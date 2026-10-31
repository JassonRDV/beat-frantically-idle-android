# Beat Frantically — Android Idle Game Prototype

An early Android idle game prototype written in Kotlin with Jetpack Compose. The code models gold, enemy health, damage per second, and upgrade progression.

## Project status

The gameplay is still being built. The current `MainActivity` has an empty Compose content block, and the game loop calculates upgrade damage without applying it to enemy health or rewards yet.

## Included in the code

- A game state model for gold, base damage, enemy health, and defeated enemies.
- Upgrade data with levels, damage bonuses, and an exponential cost formula.
- A coroutine loop that runs once per second.
- ViewModel state exposed through `StateFlow`.
- Hilt setup for dependency injection.

## Technology

Kotlin, Jetpack Compose, Material 3, AndroidX ViewModel, coroutines, StateFlow, and Hilt. Room and Navigation Compose are declared as dependencies; a complete persistence or navigation flow is not implemented in the current source.

## Getting started

1. Clone this repository and open its root folder in Android Studio.
2. Install Android SDK 36 and configure a Gradle JDK compatible with the project; the source targets Java 21.
3. Sync the Gradle project.
4. Select an emulator or device running Android 8.0 / API 26 or newer, then run the `app` configuration.

To request a debug build on Windows:

```powershell
.\gradlew.bat assembleDebug
```

The current activity does not display a playable game yet.

## Source guide

- [GameState.kt](app/src/main/java/com/example/beatfranticallyidle/model/GameState.kt): game and upgrade models.
- [GameViewModel.kt](app/src/main/java/com/example/beatfranticallyidle/viewmodel/GameViewModel.kt): state and game loop.
- [MainActivity.kt](app/src/main/java/com/example/beatfranticallyidle/MainActivity.kt): Android entry point.

## Reference images

These images are included in the repository and do not imply that the current activity implements the illustrated interface.

<p>
  <img src="images/1.png" width="200" alt="Beat Frantically reference image 1">
  <img src="images/2.png" width="200" alt="Beat Frantically reference image 2">
  <img src="images/3.png" width="200" alt="Beat Frantically reference image 3">
  <img src="images/4.png" width="200" alt="Beat Frantically reference image 4">
</p>

## License

[MIT](LICENSE).

## Contact

[Jasson Ramos on LinkedIn](https://www.linkedin.com/in/jasson-ramos-66b897340/)
