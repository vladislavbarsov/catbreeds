# Cat Breeds

This is an application that fetches data from the [TheCapApi](https://docs.thecatapi.com) and displays it in a grid inside the app. When an item is clicked, the selected cat breed details will be displayed on a new page.

### Api usage

For this application I used the option to fetch a list of cat breeds.

Base URL - 'https://api.thecatapi.com/v1/'

Get modifiers - 'breeds?limit=30&page=1/' where the limit indicate how many breeds to fetch (max is 60) and page indicates the amount of breeds per 1 page.

The returned JSON gets parsed with Moshi into data class objects.

### Features added

- Using two fragments for screens (List and Details) and using navigation to navigate between them. Both pages display their title. Details page has a back(Up) button. List fragment displays items in a grid, using RecyclerView with a GridAdapter class.
- Data is saved between state changes. Data is displayed via ViewModel and databinding.
- For bigger lists added the support for "loading" placeholder until images are fetched. Added broken image placeholder in case if the image cannot be fetched.
- String transformations for fetched data
- dimens for storing layout parameters

### Dependencies used

- Navigation - for navigating between fragments
- ViewModel - for adapting the data
- Retrofit - for making GET request
- Moshi - parsing the JSON data
- Glide - adapting url to images

### Plugins used

- android application
- kotlin-android-extensions
- kotlin-kapt
- androidx.navigation.safeargs

### Images

![Cat Breed List](/screenshots/Screenshot_List.png?raw=true) <!-- .element height="50%" width="50%" -->

![Cat Breed Details](/screenshots/Screenshot_Details.png?raw=true)
