package com.example.donadela.model

import android.os.Parcel
import android.os.Parcelable

data class Product(
    var id: Long?,
    val image: Int,
    val name: String?,
    val description: String?,
    val price: String?,
) {

}
