package com.example.coffeestarservicemen.model

sealed class ItemHistoryEventsModel {
    data class Card(
        val time: String,
        val imageBasic: Int,
        val imageSignalStatus: Int,
        val numberCar: String,
        val message: String
    ):ItemHistoryEventsModel()

    data class Header(
        val date: String
    ):ItemHistoryEventsModel()
}