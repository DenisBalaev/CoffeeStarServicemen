package com.example.coffeestarservicemen.model

data class ItemHistoryEvents(
    var isHeader:Boolean = true,
    val date:String,
    val time:String,
    val imageBasic:Int,
    val imageSignalStatus:Int,
    val numberCar:String,
    val message:String
)