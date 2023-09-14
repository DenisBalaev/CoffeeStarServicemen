package com.example.coffeestarservicemen.model

sealed class ItemFilter{
    data class ItemComboBox(val listFiltrationComboBox:List<String>):ItemFilter()
    data class ItemText(val name:String, var isActivity:Boolean = false):ItemFilter()
}