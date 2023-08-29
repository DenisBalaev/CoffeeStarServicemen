package com.example.coffeestarservicemen.model

data class ItemHistoryEvents(
    val date:String,
    val time:String,
    val imageBasic:Int,
    val imageSignalStatus:Int,
    val numberCar:String,
    val message:String
)