package com.example.coffeestarservicemen.model

sealed class ItemFilterCar{
    data class ItemComboBox(val listFiltrationComboBox:List<String>):ItemFilterCar()
    data class ItemText(val name:String, var isActivity:Boolean = false):ItemFilterCar()
}