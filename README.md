EnglishSoft
EnglishSoft is an Android application designed to help users improve their English language skills. The app includes a variety of resources such as English songs, IELTS materials, TOEFL materials, cartoons, and grammar lessons.

 Features
- **Navigation Component**: Utilizes NavHost and composable functions to manage navigation between screens.
- **LazyColumn and LazyRow**: Displays content in vertical and horizontal lists.
- **Image Slider**: Displays images in a slider format.
- **Search Box**: Provides a search box for finding content.
- **TopAppBar and Bottom Navigation Bar**: Easy access to different sections of the app via top and bottom navigation bars.
- **Modals and Drawers**: Uses modals and drawers for displaying additional content.

Project Structure
The project is organized in a modular fashion with each module placed in its respective package for better maintainability and readability.

Packages
- `com.example.englishsoft`: Main package containing the `MainActivity` class.
- `main`: Contains the main screen and related UI components.
- `rowlist`: Contains the screens related to different lists like cartoons, English songs, kids songs, proverbs, terms, grammar, and extra materials.
- `circlefirstrow`: Contains the screens for the first row of circular buttons such as adjectives, nouns, and tenses.
- `circlesecondrow`: Contains the screens for the second row of circular buttons such as IELTS, TOEFL, and school materials.
- `bottombar`: Contains the screens for the bottom navigation bar items such as about and history.

Navigation
The app uses Jetpack Compose for building the UI and the Navigation component for handling navigation between different screens.

MainActivity
`MainActivity` is the entry point of the app. It sets up the navigation controller and defines the navigation graph.

kotlin
NavHost(navController = navController, startDestination = "mainscreen") {
    composable("mainscreen") { mainscreen(...) }
    composable("toefelscreen") { toefel() }
    composable("ieltsscreen") { Ielts() }
    composable("schoolscreen") { school() }
    composable("kidssongscreen") { kidssong() }
    composable("englishsongscreen") { englishsong() }
    composable("proverbscreen") { proverb() }
    composable("termsscreen") { terms() }
    composable("grammerscreen") { grammer() }
    composable("cartoonscreen") { cartoon() }
    composable("extrascreen") { extra() }
    composable("tensescreen") { tensescreen() }
    composable("adjectivescreen") { adjectivescreen() }
    composable("nounscreen") { nounscreen() }
    composable("aboutscreen") { about() }
    composable("historyscreen") { history() }
}
```

Main Screen
The main screen displays an image slider, a row list, and two rows of circular buttons. Each item in these rows and lists navigates to its respective screen.

kotlin
@Composable
fun mainscreen(...) {
    // UI components for the main screen
}
```

Row List
Displays a horizontal list of items that navigate to different screens.

```kotlin
@Composable
fun rowlist(imageid: Array<Int>, navController: NavController) {
    // LazyRow to display items
}
```

Circle Shape Rows
Displays two rows of circular buttons that navigate to different screens.

```kotlin
@Composable
fun circleshapefirstrow(...) {
    // First row of circular buttons
}

@Composable
fun circleshapesecondrow(...) {
    // Second row of circular buttons
}
```

Bottom Navigation
The bottom navigation bar allows users to navigate to the main screen, history screen, and about screen.

```kotlin
@Composable
fun mainscreen(...) {
    Scaffold(
        topBar = { ... },
        bottomBar = {
            NavigationBar {
                // NavigationBarItems
            }
        },
        content = { contentPadding ->
            // Main content
        }
    )
}
```

How to Run
1. Clone the repository.
2. Open the project in Android Studio.
3. Build the project and run it on an emulator or a physical device.

Contributing
Feel free to fork the repository and submit pull requests. For major changes, please open an issue first to discuss what you would like to change.

License
This project is licensed under the MIT License.
```
