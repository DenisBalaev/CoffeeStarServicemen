package com.example.coffeestarservicemen.model

data class ItemCar(
    val imageSignalStatus:Int,
    val numberCar:String,
    val listFilling:List<ItemFilling>,
    val listError:List<String>,
    var time:String = "14.08",
    var address:String = "Т/Ц «Авиапарк»",
    var distance:String = "2,5 км"
)

data class ItemFilling(
    val image:Int,
    val listText:List<String>,
    val color:Int
)