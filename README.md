# MovieDb by SilasBorges 🎥

- **API consumption**. The app movideDb Api (https://developer.themoviedb.org/reference/intro/getting-started).
  
- **MVVM architecture**. The app is based on modern Android components and MVVM architecture.
- **Modularization**. Using the app and core module to have a better separation of each dependency and sending an easy-to-update code.
- **Clean Architecture**. It's development follows clean architecture practices, such as separation of core, domain, data and presentation layers.
  
- **ViewModel and LiveData**. It exposes state to the UI and encapsulates the corresponding business logic. The main advantage of the ViewModel is that it caches state and retains this information even after configuration changes.
- **Coroutines**. Extensive use of coroutines for remote data access and other operations.
- **Paging3**. Required to list paginated items coming from the api.
- **Dependency injection with Koin**.
- **Retrofit**. Used to communicate with the API.
- **Glide**. Used to format api images.
  
- **CircleImage**. This dependency helps when using images where they are rounded to be used as a profile photo, for example.
- **Binding**. Binding plays a fundamental role in a project, especially in software development contexts. It refers to the way in which parts interact and communicate within a system.
- **Detekt**. Ensuring clean and easy-to-understand code
- **Flexible UseCase class**. Employ inheritance to create a flexible UseCase<Param, Source> class.
- **ShimmerFacebook**. handling loading state and error.

This repository accesses an API that returns films in categories of recent, coming soon, most popular and also with the option to see details of the films.

## Versions

### Version 0.1
Basic functionality: listing of the most popular and top rated upcoming movies showing the movie detail, and handling of states and loading and error.

## Screenshots:
<img src="https://github.com/SilasBorges/MoviesDb/assets/49213465/2fe80c09-aecb-42b1-9f34-fc8bcbfcd350" width="300">
<img src="https://github.com/SilasBorges/MoviesDb/assets/49213465/ff5f8954-0255-4341-8246-b4faa9892942" width="300">
!<img src="https://github.com/SilasBorges/MoviesDb/assets/49213465/cd713c1c-af5b-40bb-8b32-5264b31e5360" width="300">
<img src="https://github.com/SilasBorges/MoviesDb/assets/49213465/f7dfc02d-1211-4566-a685-4bf7232285a1" width="300">
<img src="https://github.com/SilasBorges/MoviesDb/assets/49213465/9226e467-0d27-4d4f-8bf2-2502e338a394" width="300">
<img src="https://github.com/SilasBorges/MoviesDb/assets/49213465/248a33c1-6de8-45b1-b542-0496b9d9b087" width="300">

https://github.com/SilasBorges/MoviesDb/assets/49213465/1dd58420-69db-4ff4-a938-2afdbcfcb24e




