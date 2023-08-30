package com.example.coffeestarservicemen.model

data class ItemHistoryEventsModel(
    val date:String,
    val time:String,
    val imageBasic:Int,
    val imageSignalStatus:Int,
    val numberCar:String,
    val message:String
)