package com.example.coffeestarservicemen.model

interface ItemHistoryEventsModel

data class ItemHistoryCardEventsModel(
    val time: String,
    val imageBasic: Int,
    val imageSignalStatus: Int,
    val numberCar: String,
    val message: String
):ItemHistoryEventsModel

data class ItemHistoryHeaderEventsModel(
    val date: String
):ItemHistoryEventsModel