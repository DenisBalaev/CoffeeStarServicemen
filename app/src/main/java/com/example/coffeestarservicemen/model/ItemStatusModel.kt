package com.example.coffeestarservicemen.model

data class ItemStatusMainModel (
    val listError:ListError,
    val listGeneral:List<ListItemGeneralStatusModel>
)

data class ItemCardStatusModel(
    val image:Int,
    val name:String,
    val percent:Int,
    val isActive:Boolean = true
)
data class ListItemGeneralStatusModel(
    val title:String,
    val listCardGeneralStatus:List<ItemCardStatusModel>
):StatusInterface

data class ListError(val title:String,val listError: List<String>):StatusInterface

interface StatusInterface

