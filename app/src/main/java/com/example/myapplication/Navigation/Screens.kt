package com.example.myapplication.Navigation

sealed class Screens(val route: String) {
    object home: Screens("home_screen")
    object detail: Screens("detail_screen")
}