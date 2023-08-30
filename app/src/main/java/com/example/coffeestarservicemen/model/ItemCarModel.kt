package com.example.coffeestarservicemen.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemCarModel(
    val imageSignalStatus:Int,
    val numberCar:String,
    val listFilling:List<ItemFillingModel>,
    val listError:List<String>,
    var time:String = "14.08",
    var address:String = "Т/Ц «Авиапарк»",
    var distance:String = "2,5 км"
):Parcelable

@Parcelize
data class ItemFillingModel(
    val image:Int,
    val listText:List<String>,
    val color:Int
):Parcelable
