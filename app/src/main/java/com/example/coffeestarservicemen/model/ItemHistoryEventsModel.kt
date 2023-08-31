package com.example.coffeestarservicemen.model

data class ItemCardEventsModel(
    val time: String,
    val imageBasic: Int,
    val imageSignalStatus: Int,
    val numberCar: String,
    val message: String
)

data class ItemEventsModel(
    val date: String,
    val listCard:List<ItemCardEventsModel>
)